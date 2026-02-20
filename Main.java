public class Main {
    public static void main(String []args) {
        System.out.println("Hello, World");
        Simulation sim = new Simulation();

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));

        sim.start();
    }
}