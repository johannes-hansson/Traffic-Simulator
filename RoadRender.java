import java.util.ArrayList;

public class RoadRender {
    ArrayList<BreakPoint> breakPoints;
    double width;

    private class BreakPoint {
        int[] position;
        int cell;
    }

    public RoadRender() {

    }

    public ArrayList<BreakPoint> getBreakPoints() {
        return this.breakPoints;
    }
}
