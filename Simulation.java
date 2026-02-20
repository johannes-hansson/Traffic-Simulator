import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Map map;
    private boolean running = false;
    private List<SimulationUpdateListener> updateListeners = new ArrayList<>();
    private int tick = 0;

    public Map getMap() {
        return map;
    }

    public void start() {
        running = true;
        for( int i = 0; i < 20 && running; i++) {
            step();
        }
    }

    public void stop() {
        running = false;
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
}