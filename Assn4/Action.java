public abstract class Action
{
   protected Entity entity;
   protected WorldModel world;
   protected ImageStore imageStore;
   protected int repeatCount;

   public Action(Entity entity, WorldModel world,
        ImageStore imageStore, int repeatCount)
        {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
        this.repeatCount = repeatCount;
        }
   protected abstract void executeAction(EventScheduler scheduler);
}
