import java.util.ArrayList;

// Visuell representation av en väg
public class RoadRender {
    ArrayList<BreakPoint> breakPoints; // Punkter som vägen ritas mellan
    double width; // Vägens bredd

    public RoadRender(int width, BreakPoint[] breakPoints) {
        this.width = width;
        this.breakPoints = new ArrayList<>();
        for (int i=0; i<breakPoints.length; i++) {
            this.breakPoints.add(breakPoints[i]);
        }
    }

    public void displayPoints() {
        for (int i=0; i<this.breakPoints.size(); i++) {
            BreakPoint point = this.breakPoints.get(i);
            double x = point.x();
            double y = point.y();
            System.out.println("Displaying breakpoint:");
            System.out.println("x: " + Double.toString(x) + " y: " + Double.toString(y));
        }
    }

    public double getWidth() {
        return this.width;
    }

    public ArrayList<BreakPoint> getBreakPoints() {
        return this.breakPoints;
    }
}
