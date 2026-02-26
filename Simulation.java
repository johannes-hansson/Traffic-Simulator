import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private LocationalMap locationalMap;
    private boolean running = false;
    private boolean paused = false;
    private final Object pauseLock = new Object();
    private VehicleMovement vehicleMovement;
    private VehicleBehaviour vehicleBehaviour;
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<SimulationUpdateListener> updateListeners = new ArrayList<>();
    private int tick = 0;
    private int tickSpeedMs = 100;
    private Thread simThread;
    private int n_vehicles; //amount of vehicles

    //Setters
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
    public Map getMap() {
        return map;
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

        if (locationalMap != null) {
            locationalMap.addVehicle(newVehicle, startPosition);
        }
    }

    public void addUpdateListener(SimulationUpdateListener listener) {
        updateListeners.add(listener);
    }

    private void notifyListeners() {
        for (SimulationUpdateListener listener : updateListeners) {
            listener.onUpdate(this);
        }
    }

    public void start() {
        if (running) return; //Security for not starting twice
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

    private void step() {
        tick++;

        updateInfrastructure();      // traffic lights, intersections
        computeVehicleBehaviour();   // acceleration, deceleration, lane decisions
        moveVehicles();              // apply movement

        // Notify observers/UI/stats plugins
        notifyListeners();
    }

    private void computeVehicleBehaviour() {
        if (vehicleBehaviour == null) return;

        vehicleBehaviour.computeVelocities(vehicles);
        // future:
        // List<LaneSwitchDecision> decisions = vehicleBehaviour.computeLaneSwitches(...)
    }

    private void moveVehicles() {
        if (vehicleMovement == null) return;
        vehicleMovement.move(vehicles, locationalMap);
    }

    private void updateInfrastructure() {
        // TODO traffic lights, intersection logic
    }

    // TODO: delegate statistics collection to SimulationStatistics
}