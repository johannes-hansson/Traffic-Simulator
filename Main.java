public class Main{
    public static void main(String []args) throws InterruptedException {
        System.out.println("Hello, World");
        Simulation sim = new Simulation();

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));

        sim.start();

        Thread.sleep(100000);

        sim.stop();

        System.out.println("Stopped at tick: " + sim.getTick());
    }
}