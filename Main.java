import java.util.ArrayList;

public class Main{
    public static void main(String []args) throws InterruptedException {
        Map map = new Map();
        VehicleMovement movement = new VehicleMovement();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Road> roads = map.getRoads();

        VehicleProperties properties = new VehicleProperties(10, 1, 1, VehicleColor.Red);
        RoadPosition position = new RoadPosition(roads.get(0), 0, 0);
        RoadPosition position2 = new RoadPosition(roads.get(1), 0, 0);

        Vehicle vehicle = new Vehicle(properties, position, 10);
        Vehicle vehicle2 = new Vehicle(properties, position2, 0);
        roads.get(0).enterVehicle(vehicle, 0, 0);
        roads.get(1).enterVehicle(vehicle2, 0, 0);
        vehicles.add(vehicle);
        vehicles.add(vehicle2);

        for (int i=0; i<100; i++) {
            movement.process(vehicles);
        }

        /*
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
        */
    }
}