import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private boolean running = false;
    private ArrayList<Vehicle> vehicles;
    private List<SimulationUpdateListener> updateListeners = new ArrayList<>();
    private int tick = 0;
    private int tickSpeedMs = 1000;
    private Thread simThread;

    private VehicleBehaviour vehicleBehaviour;
    private VehicleMovement vehicleMovement;

    public Simulation() {
        this.map = new Map();
        this.vehicles = new ArrayList<Vehicle>();

        VehicleProperties properties = new VehicleProperties(
            100,
            5,
            1,
            VehicleColor.Red
        );
        RoadPosition position = new RoadPosition(this.map.getRoads()[0], 0, 0);
        Vehicle vehicle1 = new Vehicle(properties, position);
        this.vehicles.add(vehicle1);

        this.vehicleBehaviour = new VehicleBehaviour();
        this.vehicleMovement = new VehicleMovement();
    }

    public Map getMap() {
        return map;
    }

    public void start() {
        if (running) return; //Security for not starting twice
        running = true;
        simThread = new Thread(() -> { // A new thread that can tick simultaneously parallel
            while (running) {
                step();
                try {
                    Thread.sleep(tickSpeedMs);
                } catch (InterruptedException ignored) {
                    // Interrupting using stop() will get us here
                }
            }
        }, "SimulationThread");
        simThread.start();
    }

    public void stop() {
        running = false;
        if(simThread != null) {
            simThread.interrupt(); // Waking it up if it's asleep
        }
    }

    public void addUpdateListener(SimulationUpdateListener listener) {
        updateListeners.add(listener);
    }

    private void step() {
        tick++;
        this.vehicleBehaviour.process(this.vehicles);
        this.vehicleMovement.process(this.vehicles);

        notifyListeners();
    }

    public int getTick() {
        return tick;
    }

    private void notifyListeners() {
        for(SimulationUpdateListener listener : updateListeners) {
            listener.onUpdate(this);
        }
    }
}