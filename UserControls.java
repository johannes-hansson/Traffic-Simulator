/** Handles user interactions and translates input events into simulation actions.
 * Examples include starting the simulation, pausing/resuming, changing speed, and stopping
 * to display a statistics report.
 * In the planned architecture, UserControls communicates with SimulationManager / Simulation */
public class UserControls {
    private final SimulationManager manager;

    public UserControls(SimulationManager manager) {
        this.manager = manager;
    }

    public void onStartClicked() { manager.start(); }
    public void onPauseClicked() { manager.pause(); }
    public void onResumeClicked() { manager.resume(); }
    public void onStopClicked() { manager.stop(); }
}