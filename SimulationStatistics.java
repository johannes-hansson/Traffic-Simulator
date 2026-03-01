import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationStatistics implements SimulationUpdateListener {
    public record TickStats(
            int tick,
            int vehicleCount,
            double avgVelocity,
            int maxVelocity,
            int stoppedCount
            // TODO Avg GAP, Cars on each road, more?
    ) {}

    private final List<TickStats> history = new ArrayList<>();

    @Override
    public void onUpdate(Simulation sim) {
        collect(sim);
    }

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

    public TickStats getLatest() {
        return history.isEmpty() ? null : history.get(history.size() - 1);
    }

    public List<TickStats> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void clear() {
        history.clear();
    }
}
