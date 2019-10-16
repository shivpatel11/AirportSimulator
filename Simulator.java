import java.util.Random;

public class Simulator
{
    private Random rand;
    private int takeoffWait;
    private int landingWait;
    private int crashed;
    private int landed;
    private int tookoff;
    private TakeoffQueue<TakeoffPlane> takeoffQueue;
    private LandingPriorityQueue<LandingPlane> landingQueue;
    private int addPlane;
    private int highestWaitTakeoff;
    private int highestWaitLanding;
    private int runwayInUse =0;

    public Simulator()
    {
        rand = new Random();
        takeoffWait = 0;
        landingWait = 0;
        crashed = 0;
        landed = 0;
        tookoff = 0;
        addPlane = 0;
        highestWaitLanding = 0;
        highestWaitTakeoff = 0;
        takeoffQueue = new TakeoffQueue<>();
        landingQueue = new LandingPriorityQueue<>();
        int add = rand.nextInt(2)+1;
        if(add == 1)
        {
            TakeoffPlane one = new TakeoffPlane(0);
            takeoffQueue.enqueue(one);
        } else
        {
            int fuel = rand.nextInt(11)+5;
            LandingPlane two = new LandingPlane(fuel,false,false,0);
            landingQueue.add(two);
        }
    }
    public void update(int currentTime)
    {
        if(landingQueue.isEmpty() && runwayInUse == 0)
        {
            if(!takeoffQueue.isEmpty()) {
                takeoffQueue.getFront().updateTakeoffTime();
            }
            if(!takeoffQueue.isEmpty() && takeoffQueue.getFront().updateTakeoffTime())
            {
                tookoff++;
                takeoffQueue.getFront().setWaitTime(currentTime-takeoffQueue.getFront().getTimeArrived());
                int wait = currentTime - takeoffQueue.getFront().getTimeArrived();
                takeoffWait += wait;
                if(wait > highestWaitTakeoff)
                {
                    highestWaitTakeoff = wait;
                }
                takeoffQueue.dequeue();
                runwayInUse = 3;
            }
        }
        if(!landingQueue.isEmpty() && runwayInUse == 0)
        {
            landingQueue.updateValues();
            if(!landingQueue.isEmpty()) {
                landingQueue.peek().updateLandingPlane();
            }
            if(!landingQueue.isEmpty() && landingQueue.peek().isCrashed()==false && landingQueue.peek().updateLandingPlane())
            {
                landed++;
                int wait = currentTime - landingQueue.peek().getTimeArrived();
                landingWait += wait;
                if(wait > highestWaitLanding)
                {
                    highestWaitLanding = wait;
                }
                landingQueue.remove();
                runwayInUse = 2;
                if(!landingQueue.isEmpty()) {
                    landingWait += currentTime - landingQueue.peek().getTimeArrived();
                }
            } else if(landingQueue.peek().isCrashed()) {
                crashed++;
                landingQueue.remove();
            }
        }
        addPlane++;
        //add plane
        if(addPlane%2==0)
        {
            int add = rand.nextInt(2) + 1;
            if (add == 1) {
                TakeoffPlane b = new TakeoffPlane(currentTime);
                takeoffQueue.enqueue(b);
            } else {
                int fuel = rand.nextInt(11) + 5;
                LandingPlane c = new LandingPlane(fuel, false, false, currentTime);
                landingQueue.add(c);
            }
        }
        if(runwayInUse > 0) {
            runwayInUse--;
        }
    }

    public int getTakeoffWait()
    {
        return takeoffWait;
    }
    public int getLandingWait()
    {
        return landingWait;
    }
    public int getCrashed()
    {
        return crashed;
    }
    public int getLanded()
    {
        return landed;
    }
    public int getTookoff()
    {
        return tookoff;
    }
    public int getHighestWaitTakeoff()
    {
        return highestWaitTakeoff;
    }
    public int getHighestWaitLanding()
    {
        return highestWaitLanding;
    }
}
