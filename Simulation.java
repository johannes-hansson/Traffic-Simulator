import java.util.ArrayList;
import java.util.List;

/** Simulation is the core component of the traffic simulator.
 * It maintains the current simulation state including vehicles,
 * map and mobility model. It is responsible for executing
 * simulation ticks and notifying update listeners. */
public class Simulation {

    // Different possible speed modes
    public enum SpeedMode { SLOW, NORMAL, FAST }

    private SpeedMode speedMode = SpeedMode.NORMAL;
    private Map map;
    private LocationalMap locationalMap;
    private boolean running = false;
    private boolean paused = false;
    private final Object pauseLock = new Object();
    private VehicleMovement vehicleMovement;
    private VehicleBehaviour vehicleBehaviour;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private List<SimulationUpdateListener> updateListeners = new ArrayList<>();
    private int tick = 0;
    private int tickSpeedMs = 100;
    private Thread simThread;
    private int n_vehicles; //amount of vehicles

    // Empty constructor
    public Simulation() {}

    // Constructor for creating default components
    public static Simulation createDefault() {
        Simulation sim = new Simulation();
        sim.setMap(new Map());
        sim.setVehicleBehaviour(new VehicleBehaviour());
        sim.setVehicleMovement(new VehicleMovement());
        sim.setSpeedMode(SpeedMode.NORMAL);
        return sim;
    }

    // Constructor for creating a simulation with 2 vehicles and statistics for testing
    public static Simulation createDemoWithStats() {
        Simulation sim = createDefault();

        // add vehicles
        Road road = sim.getMap().getRoads().get(0);
        RoadPosition start1 = new RoadPosition(road, 10, 0);
        RoadPosition start2 = new RoadPosition(road, 8, 0);

        sim.addVehicle(new Car(start1, 0, VehicleColor.Red), start1);
        sim.addVehicle(new Car(start2, 3, VehicleColor.blue), start2);

        // stats plugin
        SimulationStatistics stats = new SimulationStatistics();
        sim.addUpdateListener(stats);

        // debug prints (demo)
        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));
        sim.addUpdateListener(s -> {
            var latest = stats.getLatest();
            if (latest != null && latest.tick() % 5 == 0) System.out.println(latest);
        });
        sim.addUpdateListener(s -> {
            for (Vehicle v : s.getVehicles()) {
                System.out.println(
                        v.getProperties().color() +
                                " cell=" + v.getPosition().cell() +
                                " vel=" + v.getVelocity()
                );
            }
        });

        return sim;
    }

    //Setters

    public void setSpeedMode(SpeedMode mode){
    this.speedMode = mode;
        switch (mode) {
            case SLOW -> setTickSpeedMs(250);
            case NORMAL -> setTickSpeedMs(100);
            case FAST -> setTickSpeedMs(25);
        }
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setLocationalMap(LocationalMap locationalMap) {
        this.locationalMap = locationalMap;
        if (this.locationalMap != null) {
            this.locationalMap.setSimulation(this);
        }
    }

    public void setVehicleMovement(VehicleMovement vehicleMovement) {
        this.vehicleMovement = vehicleMovement;
    }

    public void setVehicleBehaviour(VehicleBehaviour vehicleBehaviour) {
        this.vehicleBehaviour = vehicleBehaviour;
    }

    public void setTickSpeedMs(int tickSpeedMs) {
        if (tickSpeedMs < 0) throw new IllegalArgumentException("tickSpeedMs must be >= 0");
        this.tickSpeedMs = tickSpeedMs;
    }

    //Getters

    public SpeedMode getSpeedMode() {
        return speedMode;
    }

    public Map getMap() {
        return this.map;
    }

    public int getTick() {
        return tick;
    }

    public int getVehicleAmount() {
        return n_vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle newVehicle, RoadPosition startPosition) {
        vehicles.add(newVehicle);
        n_vehicles = vehicles.size();

       /* if (locationalMap != null) {
            locationalMap.addVehicle(newVehicle, startPosition);
        }*/
    }

    /** Registers an observer/listener that will receive SimulationUpdateListener.onUpdate(Simulation)
     * after every tick */
    public void addUpdateListener(SimulationUpdateListener listener) {
        updateListeners.add(listener);
    }

    private void notifyListeners() {
        for (SimulationUpdateListener listener : updateListeners) {
            listener.onUpdate(this);
        }
    }

    /** Starts the simulation loop in a separate thread if not already running.
     * The loop executes step() repeatedly with a sleep delay based on tickSpeedMs. */
    public void start() {
        if (running) return; //Security for not starting twice
        validateConfiguration();
        running = true;
        simThread = new Thread(() -> { // A new thread that can tick simultaneously parallel
            while (running) {

                // Pause gate: if paused, wait here until resume() or stop()
                synchronized (pauseLock) {
                    while (paused && running) {
                        try {
                            pauseLock.wait();
                        } catch (InterruptedException ignored) {
                            // stop() may interrupt the thread to wake it up
                        }
                    }
                }

                // If stop() was called while paused, exit cleanly
                if (!running) break;

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

    private void validateConfiguration() {
        if (map == null) throw new IllegalStateException("Map not set");
        if (vehicleMovement == null) throw new IllegalStateException("VehicleMovement not set");
        if (vehicleBehaviour == null) throw new IllegalStateException("VehicleBehaviour not set");
    }

    /** Stops the simulation loop and wakes the thread if it is sleeping or paused.
     * After stop, the simulation is no longer running until start() is called again. */
    public void stop() {
        running = false;
        if (simThread != null) {
            simThread.interrupt(); // Waking it up if it's asleep
        }
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    /** Executes one simulation tick: updates infrastructure, computes behaviour, moves vehicles,
     * then notifies all listeners. */
    private void step() {
        tick++;


       // updateInfrastructure();      // traffic lights, intersections
        computeVehicleBehaviour();   // acceleration, deceleration, lane decisions

        moveVehicles();              // apply movement

        // Notify observers/UI/stats plugins
        notifyListeners();
    }

    private void computeVehicleBehaviour() {
        if (vehicleBehaviour == null) return;

       // vehicleBehaviour.computeVelocities(vehicles);
        // future:
        // List<LaneSwitchDecision> decisions = vehicleBehaviour.computeLaneSwitches(...)
    }

    private void moveVehicles() {
        if (vehicleMovement == null) return;
      
        //vehicleMovement.move(vehicles, locationalMap);
    }

    //private void updateInfrastructure() {

        // TODO traffic lights, intersection logic
    //}

    // TODO: delegate statistics collection to SimulationStatistics
}