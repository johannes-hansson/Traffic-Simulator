public class Main{
    public static void main(String []args) throws InterruptedException {
        Simulation sim = new Simulation();
        sim.setTickSpeedMs(100);

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));

        sim.start();

        Thread.sleep(350);

        sim.pause();
        int pausedAt = sim.getTick();
        System.out.println("Paused at tick: " + pausedAt);

        Thread.sleep(400);
        System.out.println("Still paused tick: " + sim.getTick());

        sim.resume();
        Thread.sleep(300);

        sim.stop();

        System.out.println("Stopped at tick: " + sim.getTick());
    }
}