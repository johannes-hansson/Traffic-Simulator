import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class View implements SimulationUpdateListener {

    private Pane roadLayer; // drawing surface
    private Pane vehicleLayer;
    private boolean roadsDrawn = false;

    public View(Pane roadLayer, Pane vehicleLayer) {
        this.roadLayer = roadLayer;
        this.vehicleLayer = vehicleLayer;
    }

    @Override
    public void onUpdate(Simulation simulation) {

        Platform.runLater(() -> {

            Map map = simulation.getMap(); // get map from simulation

            ArrayList<Road> roads = map.getRoads(); // get all roads

            if(!roadsDrawn){
                for (Road road : roads){
                    road.getRoadRender().draw(roadLayer);
                }
                roadsDrawn = true;
            }

            for (Vehicle vehicle : simulation.getVehicles()){
                Rectangle vehicleGraphic = vehicle.getGraphic(); // get the rectangle that represents the car
                
                // Check the the vehicle graphic exists and create one otherwise
                if (vehicleGraphic == null) {
                    vehicleGraphic = new Rectangle(4, 8);
                    vehicleGraphic.setFill(Color.RED);

                    vehicle.setGraphic(vehicleGraphic); // connect to the graphics
                }

                // Check if the vehicle graphic exists in the vehicle layer
                // Add it otherwise
                if(!vehicleLayer.getChildren().contains(vehicleGraphic)) {
                    vehicleLayer.getChildren().add(vehicleGraphic);
                }

                Road road = vehicle.getPosition().road();
                int cell = vehicle.getPosition().cell();

                ArrayList<BreakPoint> points = road.getRoadRender().getBreakPoints();
                if (points.size() < 2) continue;

                int lowerBreakPointIndex = 0;
                int upperBreakPointIndex = points.size() - 1;

                while (upperBreakPointIndex - lowerBreakPointIndex > 1) {
                    int middleBreakPointIndex = (int)Math.floor((upperBreakPointIndex + lowerBreakPointIndex) / 2);
                    BreakPoint middleBreakPoint = points.get(middleBreakPointIndex);
                    if (middleBreakPoint.cell() >= cell) {
                        upperBreakPointIndex = middleBreakPointIndex;
                    } else {
                        lowerBreakPointIndex = middleBreakPointIndex;
                    }
                }

                BreakPoint p1 = points.get(lowerBreakPointIndex);
                BreakPoint p2 = points.get(upperBreakPointIndex);

                double cellDiff = (p2.cell() - p1.cell());
                double t = 0;

                if(cellDiff != 0){
                    t = (double)(cell - p1.cell()) / cellDiff;
                }

                t = Math.max(0, Math.min(1, t));

                double x = p1.x() + (p2.x() - p1.x()) * t;
                double y = p1.y() + (p2.y() - p1.y()) * t;

                r.setX(x - r.getWidth()/2);
                r.setY(y - r.getHeight()/2);
            }

            // here we can add drawing cars and traffic lights etc
        });
    }
}





/*

 View component that observes the simulation and visualizes the current state.
 Intended as a plugin registered via Simulation.addUpdateListener(SimulationUpdateListener).

public class View implements SimulationUpdateListener {

    @Override
    public void onUpdate(Simulation simulation) {
        // Hämta kartan för simulationen
        Map map = simulation.getMap();

        // Hämta alla vägar från kartan
        ArrayList<Road> roads = map.getRoads();

        // Ett exempel på hur vägar kan ritas med hjälp av en
        // RoadRender komponent som har lagts till till Road
        for (Road road : roads) {
            // Road har en metod getRoadRender() som returnerar
            // en RoadRender

            RoadRender render = road.getRoadRender();

            // RoadRender har en metod getWidth() som returnerar
            // vägens bredd

            double width = render.getWidth();

            // Road render har en metod getBreakPoints() som returnerar
            // en ArrayList med BreakPoint
            // BreakPoint är en klass som innehåller information om vilka
            // punkter en väg ska ritas mellan
            // BreakPoint har en metod x() som returnerar dess x-koordinat
            // BreakPoint har en metod y() som returnerar dess y-koordinat
            // Breakpoint har en metod cell() som returnerar vilken cell på vägen
            // den gäller för

            ArrayList<BreakPoint> breakPoints = render.getBreakPoints();

            // RoadRender har även en metod displayPoints för att skriva ut alla breakPoints
            // render.displayPoints();

            // Gå sedan igenom alla punkter förrutom den sista
            // Rita ett streck från punkt i till punkt i+1 med bredd width
            for (int i = 0; i < breakPoints.size() - 1; i++) {

                BreakPoint currentPoint = breakPoints.get(i);
                BreakPoint nextPoint = breakPoints.get(i + 1);

                // Nu kan ett streck (vägen) ritas mellan currentPoint.x(), currentPoint.y()
                // och nextPoint.x(), nextPoint.y() med bredden width

                double xStart = currentPoint.x();
                double yStart = currentPoint.y();
                double xEnd = nextPoint.x();
                double yEnd = nextPoint.y();

                // drawLine(xStart, yStart, xEnd, yEnd, width);
            }
        }
    }
} */
