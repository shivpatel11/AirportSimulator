public class LandingPlane implements Comparable<LandingPlane>, Updatable
{
    //how long it takes to land
    private int landingTime;
    //how much fuel is left
    private int fuel;
    //did the plane land
    private boolean landed;
    //did the plane crash or not
    private boolean crashed;
    private int timeArrived;
    private int waitTime;

    public LandingPlane(int fuel, boolean landed, boolean crashed, int arrived)
    {
        this.fuel = fuel;
        this.landed = landed;
        this.crashed = crashed;
        landingTime = 2;
        timeArrived = arrived;
        waitTime = 0;
    }

    public int getFuel()
    {
        return fuel;
    }
    public int getLandingTime()
    {
        return landingTime;
    }
    public boolean isLanded()
    {
        return landed;
    }
    public boolean isCrashed()
    {
        return crashed;
    }
    //returns if the plane crashed or not
    public boolean updateLandingPlane()
    {
        landingTime--;
        waitTime++;
        if(landingTime==0 && fuel!=0)
        {
            landed = true;
        }
        if(landingTime!=0 && fuel == 0 && !landed)
        {
            crashed = true;
        }
        return landed;
    }
    //compare planes by fuel
    public int compareTo(LandingPlane other)
    {
        if (fuel < other.fuel)
            return 1;
        if (fuel > other.fuel)
            return -1;
        return 0;
    }
    public void update()
    {
        fuel--;
    }
    public int getTimeArrived()
    {
        return timeArrived;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    public int getWaitTime()
    {
        return waitTime;
    }
}
