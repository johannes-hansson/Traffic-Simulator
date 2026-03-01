/** Immutable (or logically immutable) value object describing a vehicle's position on a road.
 * A position is defined by (road, lane, cell) where cell is the discrete index along the road.
 * This representation supports cell-based traffic simulation and collision rules (one vehicle per cell) */
public record RoadPosition (Road road, int cell, int lane) {};
