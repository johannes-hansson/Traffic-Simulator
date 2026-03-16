import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/** Lightweight data model describing how a road should be rendered.
 * Stores width and a sequence of BreakPoint's that define the polyline geometry. */
// Visuell representation av en väg
public class RoadRender {
    ArrayList<BreakPoint> breakPoints; // Punkter som vägen ritas mellan
    double width; // Vägens bredd

    public BreakPoint getEndPoint() { // get the end of the road
        return breakPoints.get(breakPoints.size() - 1);
    }

    public RoadRender(int width, BreakPoint[] breakPoints) {
        this.width = width;
        this.breakPoints = new ArrayList<>();
        for (int i=0; i<breakPoints.length; i++) {
            this.breakPoints.add(breakPoints[i]);
        }
    }

    public double getWidth() {
        return this.width;
    }

    public ArrayList<BreakPoint> getBreakPoints() {
        return this.breakPoints;
    }

    public void draw(Pane root, Road road) {

        ArrayList<Line> laneMarkings = new ArrayList<>();

        // Draw between each pair of points
        for (int i = 0; i < breakPoints.size() - 1; i++){
            BreakPoint p1 = breakPoints.get(i); // get first point (start)
            BreakPoint p2 = breakPoints.get(i + 1); // get second point (end)

            Line roadSegment = new Line( // here we create the line
                    p1.x(), p1.y(),
                    p2.x(), p2.y()
            );

            roadSegment.setStrokeWidth(width); // width of road
            roadSegment.setStroke(Color.WHITE); // color of road

            root.getChildren().add(roadSegment);

            // Draw lane markings
            double dx = p2.x() - p1.x();
            double dy = p2.y() - p1.y();
            double length = Math.sqrt(dx * dx + dy * dy);
            double[] perpendicularUnitVector = new double[] {
                    -dy / length,
                    dx / length
            };

            double laneWidth = roadSegment.getStrokeWidth() / road.getLanes();
            double segmentStartX = p1.x() + perpendicularUnitVector[0] * this.width / 2;
            double segmentStartY = p1.y() + perpendicularUnitVector[1] * this.width / 2;
            double segmentEndX = p2.x() + perpendicularUnitVector[0] * this.width / 2;
            double segmentEndY = p2.y() + perpendicularUnitVector[1] * this.width / 2;

            for (int j = 1; j < road.getLanes(); j++) {
                double startX = segmentStartX - perpendicularUnitVector[0] * laneWidth * j;
                double startY = segmentStartY - perpendicularUnitVector[1] * laneWidth * j;
                double endX = segmentEndX - perpendicularUnitVector[0] * laneWidth * j;
                double endY = segmentEndY - perpendicularUnitVector[1] * laneWidth * j;

                Line laneMarking = new Line(
                        startX, startY,
                        endX, endY
                );

                laneMarking.setStrokeWidth(1);
                laneMarking.setStroke(Color.BLACK);
                laneMarking.getStrokeDashArray().addAll(5.0, 5.0);
                laneMarkings.add(laneMarking);
            }

            /*root = Pane = drawing surface / empty box
            getChildren = all that is within the box
            add = adds our lines*/

        }

        for (Line laneMarking : laneMarkings) {
            root.getChildren().add(laneMarking);
        }

    }

}
