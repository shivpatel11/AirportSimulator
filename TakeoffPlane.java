public class TakeoffPlane
{
    //how long it takes to take off
    private int takeoffTime;
    //when did the plane get ready to takeoff
    private int timeArrived;
    private int waitTime;

    public TakeoffPlane(int timeArrived)
    {
        this.timeArrived = timeArrived;
        takeoffTime = 3;
        waitTime = 0;
    }
    public int getTimeArrived()
    {
        return timeArrived;
    }
    public int getTakeoffTime()
    {
        return takeoffTime;
    }
    public int getWaitTime()
    {
        return waitTime;
    }
    public void setWaitTime(int waitTime)
    {
        this.waitTime = waitTime;
    }
    //returns true if takeoff time is done
    public boolean updateTakeoffTime()
    {
        takeoffTime--;
        //waitTime++;
        return takeoffTime <= 0;
    }
}
