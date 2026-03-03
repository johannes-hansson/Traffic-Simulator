import java.util.ArrayList;

public interface Node {
    public ArrayList<Road> getAvailableTurns(Road incoming);
    public int[][] getLaneMap(Road incoming, Road outgoing);
    public boolean requestTurn(Road incoming, Road outgoing);
}
