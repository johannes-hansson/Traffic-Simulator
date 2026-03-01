public class Main{
    public static void main(String []args) throws InterruptedException {
        Simulation sim = new Simulation();
        SimulationStatistics stats = new SimulationStatistics();
        sim.setLocationalMap(new LocationalMap());
        sim.setVehicleMovement(new VehicleMovement());
        sim.setVehicleBehaviour(new VehicleBehaviour());
        sim.setMap(new Map());
        Road road = sim.getMap().getRoads().get(0);
        RoadPosition start = new RoadPosition(road, 0, 0);
        sim.addVehicle(new Car(start, 0, VehicleColor.Red), start);
        sim.setTickSpeedMs(100);

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));
        sim.addUpdateListener(stats);

        sim.addUpdateListener(s -> {
            var latest = stats.getLatest();
            if (latest != null && latest.tick() % 5 == 0) { //printing statistics each 5 ticks
                System.out.println(latest);
            }
        });

        sim.addUpdateListener(s -> {
            Vehicle v = s.getVehicles().get(0);
            System.out.println("cell=" + v.getPosition().cell() + " vel=" + v.getVelocity());
        });

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