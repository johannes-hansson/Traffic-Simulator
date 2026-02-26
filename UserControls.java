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