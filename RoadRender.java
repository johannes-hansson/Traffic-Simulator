import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;


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

    public void draw(Pane root) {

        // Draw between each pair of points
        for (int i = 0; i < breakPoints.size() - 1; i++){
            BreakPoint p1 = breakPoints.get(i); // get first point (start)
            BreakPoint p2 = breakPoints.get(i + 1); // get second point (end)

            Line roadSegment = new Line( // here we create the line
                    p1.x(), p1.y(),
                    p2.x(), p2.y()
            );

            roadSegment.setStrokeWidth(width); // width of road
            roadSegment.setStroke(Color.DARKGRAY); // color of road

            root.getChildren().add(roadSegment);
            /*
            root = Pane = drawing surface / empty box
            getChildren = all that is within the box
            add = adds our lines
            */
        }

    }

}
