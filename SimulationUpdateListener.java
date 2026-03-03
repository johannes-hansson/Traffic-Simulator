/** Observer interface for simulation tick updates.
 * Implementations can react to each completed tick (e.g., render the view, collect statistics).
 *
 * This enables a plugin-like architecture where components subscribe to state updates
 * without being tightly coupled to the simulation core. */
public interface SimulationUpdateListener {

    /** Called after a simulation tick has been processed.*/
    public void onUpdate(Simulation simulation);
}