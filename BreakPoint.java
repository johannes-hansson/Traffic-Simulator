/** A geometric point used for rendering roads.
 * Connects a coordinate (x,y) to a logical cell index along a road */
public record BreakPoint (double x, double y, int cell) {}
