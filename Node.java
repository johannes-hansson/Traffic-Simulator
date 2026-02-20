import java.util.Vector;

public interface Node {
    public Road[] getAvailableTurns(Road incoming);
    public Vector<int[]> getLaneMap(Road incoming, Road outgoing);
    public boolean requestTurn(Road incoming, Road outgoing);
}
