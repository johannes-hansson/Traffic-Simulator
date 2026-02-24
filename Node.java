import java.util.Vector;

public interface Node {
    public Vector<Road> getAvailableTurns(Road incoming);
    public int[][] getLaneMap(Road incoming, Road outgoing);
    public boolean requestTurn(Road incoming, Road outgoing);
}
