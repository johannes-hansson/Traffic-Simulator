public class FelixTestClass {

    public static void main(String[] args) throws InterruptedException {
        // Build a ready-to-run demo simulation (map + behaviour + movement + 2 cars + stats + debug listeners)
        Simulation sim = Simulation.createDemoWithStats();

        // Start simulation
        sim.start();

        // Let it run a bit
        Thread.sleep(350);

        // Pause
        sim.pause();
        int pausedAt = sim.getTick();
        System.out.println("Paused at tick: " + pausedAt);

        // Wait while paused (tick should not change)
        Thread.sleep(400);
        System.out.println("Still paused tick: " + sim.getTick());

        // Resume and let it run a bit more
        sim.resume();
        Thread.sleep(300);

        // Stop
        sim.stop();
        System.out.println("Stopped at tick: " + sim.getTick());

        // Optional: give the simulation thread a tiny moment to exit cleanly
        Thread.sleep(50);
    }
}