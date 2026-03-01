import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Collects and stores simple metrics from the simulation state over time.
 * Intended to be registered as a SimulationUpdateListener so that statistics
 * are gathered automatically after each tick.
 * The collected history can be used to display summaries when the simulation stops
 * or for debugging/verification during development. */
public class SimulationStatistics implements SimulationUpdateListener {

    /** Immutable snapshot of a few statistics for a single tick.
     * Records are lightweight data carriers suitable for logging and history storage. */
    public record TickStats(
            int tick,
            int vehicleCount,
            double avgVelocity,
            int maxVelocity,
            int stoppedCount
            // double avgGap, TODO when occupancy is stable
            // int overlaps TODO when occupancy is stable, to see if any vehicles collide
            // TODO Avg GAP, Cars on each road, collisions, more?
    ) {}

    private final List<TickStats> history = new ArrayList<>();

    /** Triggered by the simulation after each tick when registered as a listener.
     * Delegates to collect(Simulation) */
    @Override
    public void onUpdate(Simulation sim) {
        collect(sim);
    }

    /** Collects current metrics from the simulation state and appends to the history.
     * This method is separated so it can be called manually in tests if needed. */
    public void collect(Simulation sim) {
        List<Vehicle> vehicles = sim.getVehicles();

        int count = vehicles.size();
        int sumVel = 0;
        int maxVel = 0;
        int stopped = 0;

        for (Vehicle v : vehicles) {
            int vel = v.getVelocity();
            sumVel += vel;
            if (vel > maxVel) maxVel = vel;
            if (vel == 0) stopped++;
        }

        double avg = (count == 0) ? 0.0 : ((double) sumVel) / count;

        history.add(new TickStats(sim.getTick(), count, avg, maxVel, stopped));
    }

    /** return the most recent TickStats entry, or null if no data has been collected */
    public TickStats getLatest() {
        return history.isEmpty() ? null : history.get(history.size() - 1);
    }


    /** return an unmodifiable view of the full statistics history */
    public List<TickStats> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void clear() {
        history.clear();
    }
}
