import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetX1()
   {
      assertEquals(1.0, new Point(1.0, 2.0).getX(), DELTA);
   }
   @Test
   public void testGetX2 ()
   {
      assertEquals(-1.0, new Point(-1.0, 3.0).getX(), DELTA);
   }
    @Test
   public void testGetX3 ()
   {
      assertEquals(4.0, new Point(4.0, -2.0).getX(), DELTA);
   }
    @Test
   public void testGetY1 ()
   {
      assertEquals(3.0, new Point(-1.0, 3.0).getY(), DELTA);
   }
    @Test
   public void testGetY2 ()
   {
      assertEquals(-2.0, new Point(-1.0, -2.0).getY(), DELTA);
   }
    @Test
   public void testGetY3 ()
   {
      assertEquals(5.0, new Point(4.0, 5.0).getY(), DELTA);
   }
    @Test
   public void getRadius1 ()
   {
      assertEquals(Math.sqrt(10), new Point(-1.0, 3.0).getRadius(), DELTA);
   }
    @Test
   public void getRadius2 ()
   {
      assertEquals(5.0, new Point(4.0, 3.0).getRadius(), DELTA);
   }
@Test
   public void getRadius3 ()
   {
      assertEquals(5.0, new Point(-4.0, 3.0).getRadius(), DELTA);
   }
    @Test
   public void getAngle1 ()
   {
      assertEquals(0.0, new Point(0.0,1.0).getAngle(), DELTA);
   }
   @Test
   public void getAngle2 ()
   {
      assertEquals(Math.PI/2, new Point(1.0,0.0).getAngle(), DELTA);
   }
   @Test
   public void getAngle13 ()
   {
      assertEquals(Math.PI/3, new Point(Math.sqrt(3),1.0).getAngle(), DELTA);
   }
@Test
   public void rotate90_1 ()
   {
      Point p = new Point(1.0,1.0);
      Point p1 = p.rotate90();
      assertEquals(-1.0, p1.getX(), DELTA);
      assertEquals(1.0, p1.getY(), DELTA);
   }
   @Test
   public void rotate90_2 ()
   {
      Point p = new Point(0.0,-2.0);
      Point p1 = p.rotate90();
      assertEquals(2.0, p1.getX(), DELTA);
      assertEquals(0.0, p1.getY(), DELTA);
   }
   @Test
   public void rotate90_3 ()
   {
      Point p = new Point(-2.0,-4.0);
      Point p1 = p.rotate90();
      assertEquals(4.0, p1.getX(), DELTA);
      assertEquals(-2.0, p1.getY(), DELTA);
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */

   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getX",
         "getY",
         "getRadius",
         "getAngle",
         "rotate90"
         );

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class,
         double.class,
         double.class,
         double.class,
         Point.class
         );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0]
         );

      verifyImplSpecifics(Point.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, Point.class.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
