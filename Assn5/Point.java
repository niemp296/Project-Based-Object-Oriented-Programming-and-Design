final class Point
{
   public final int x;
   public final int y;

   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   public int getX(){ return x;}
   public int getY() { return y;}
   public String toString()
   {
      return "(" + x + "," + y + ")";
   }

   public boolean equals(Object other)
   {
      return other instanceof Point &&
         ((Point)other).x == this.x &&
         ((Point)other).y == this.y;
   }

   public int hashCode()
   {
      int result = 17;
      result = result * 31 + x;
      result = result * 31 + y;
      return result;
   }
   public boolean adjacent(Point p)
   {
      return (this.x == p.x && Math.abs(this.y - p.y) == 1) ||
              (this.y == p.y && Math.abs(this.x - p.x) == 1);
   }
}
