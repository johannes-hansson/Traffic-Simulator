/** Data object representing a lane switching decision for a vehicle at a specific tick.
 * Used as an intermediate result between behaviour computation (decision) and movement (execution) */
public record LaneSwitchDecision(Vehicle vehicle, int direction) {}