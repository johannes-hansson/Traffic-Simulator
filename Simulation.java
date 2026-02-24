import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private LocationMap spatialMap;
    private boolean running = false;
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<SimulationUpdateListener> updateListeners = new ArrayList<>();
    private int tick = 0;
    private int tickSpeedMs = 100;
    private Thread simThread;
    private int n_vehicles; //amount of vehicles

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

    public int getVehicleAmount(){
        return n_vehicles; }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }
}