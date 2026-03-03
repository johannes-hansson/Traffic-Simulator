/** High-level coordinator that wires together core components (Simulation, View, Controls, Statistics)
 * and manages application lifecycle concerns (startup, shutdown, user-driven state transitions).
 * Intended as the boundary between the simulation kernel and the UI/application layer */
public class SimulationManager {
    private final Simulation simulation;

    public SimulationManager(Simulation simulation) {
        this.simulation = simulation;
    }

    public void start() { simulation.start(); }
    public void stop() { simulation.stop(); }
    public void pause() { simulation.pause(); }
    public void resume() { simulation.resume(); }

    public int getTick() { return simulation.getTick(); }
    public Simulation getSimulation() { return simulation; }
}