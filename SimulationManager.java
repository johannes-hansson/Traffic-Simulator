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