public class Main
{
    public static void main(String[] args)
    {
        Simulator simulator = new Simulator();
        for (int i = 0; i < 60; i++)
        {
            simulator.update(i);
        }

        System.out.println("Average Takeoff Time:" + (simulator.getTakeoffWait()/simulator.getTookoff()));
        System.out.println("Highest Takeoff Wait:" + simulator.getHighestWaitTakeoff());
        System.out.println("Average Landing Time:" + (simulator.getLandingWait()/simulator.getLanded()));
        System.out.println("Highest Landing Wait:" + simulator.getHighestWaitLanding());
        System.out.println("Planes the crashed:" + simulator.getCrashed());
        System.out.println("Takeoff Planes:" + simulator.getTookoff());
        System.out.println("Landed Planes:" + simulator.getLanded());
    }
}
