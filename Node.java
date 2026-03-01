import java.util.Vector;

/** Represents a connection point in the road network (e.g., intersection or road endpoint).
 * Nodes manage incoming/outgoing roads and are responsible for turn permissions and conflicts. */
public interface Node {
    public Vector<Road> getAvailableTurns(Road incoming);
    public int[][] getLaneMap(Road incoming, Road outgoing);
    public boolean requestTurn(Road incoming, Road outgoing);
}
