/** Immutable configuration for a vehicle type.
 * Contains parameters used by behaviour rules, e.g. max velocity, acceleration, size (cells),
 * and visual identity such as color. */
public record VehicleProperties(int maxVelocity, int acceleration, int[] size, VehicleColor color) {}
