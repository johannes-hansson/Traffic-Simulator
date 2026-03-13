import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class View implements SimulationUpdateListener {

    private Pane roadLayer; // drawing surface
    private Pane vehicleLayer;
    private boolean roadsDrawn = false;

    double trafficLightDistance = 10; // The distance between traffic lights to the intersections

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
                
                // Check that the vehicle graphic exists and create one otherwise
                if (vehicleGraphic == null) {
                    VehicleProperties properties = vehicle.getProperties();
                    int[] size = properties.size();

                    vehicleGraphic = new Rectangle(size[0], size[1]);
                    vehicleGraphic.setFill(properties.color().getJavaFxColor());

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

                double breakPointsDeltaX = p2.x() - p1.x();
                double breakPointsDeltaY = p2.y() - p1.y();

                // Calculate the render position for the vehicle
                double cellDiff = (p2.cell() - p1.cell());
                double t = 0;

                if(cellDiff != 0){
                    t = (double)(cell - p1.cell()) / cellDiff;
                }

                t = Math.max(0, Math.min(1, t));

                double x = p1.x() + (breakPointsDeltaX) * t;
                double y = p1.y() + (breakPointsDeltaY) * t;

                vehicleGraphic.setX(x - vehicleGraphic.getWidth()/2);
                vehicleGraphic.setY(y - vehicleGraphic.getHeight()/2);

                // Calculate the tilt of the vehicle
                double tiltAngleRadians = Math.atan2(breakPointsDeltaY, breakPointsDeltaX);
                vehicleGraphic.setRotate(tiltAngleRadians * 180 / Math.PI);
            }

            // Update traffic lights
            ArrayList<Infrastructure> infrastructures = map.getInfrastructures();
            for (Infrastructure infrastructure : infrastructures) {
                // Check that the current node has a traffic light
                TrafficLight trafficLight = null;
                if (infrastructure instanceof TrafficLight light) {
                    trafficLight = light;
                }

                if (trafficLight == null) {
                    continue;
                }

                for (TrafficLight.TrafficLightConnection connection : trafficLight.getConnections()) {
                    Circle lamp = connection.getLight();
                    Road road = connection.getRoad();
                    if (lamp == null) {
                        ArrayList<BreakPoint> breakPoints = road.getRoadRender().getBreakPoints();
                        BreakPoint lastBreakPoint = breakPoints.get(breakPoints.size() - 1);
                        BreakPoint secondLastBreakPoint = breakPoints.get(breakPoints.size() - 2);

                        // Find the unit vector between the two last break points
                        double[] direction = new double[] {
                                lastBreakPoint.x() - secondLastBreakPoint.x(),
                                lastBreakPoint.y() - secondLastBreakPoint.y()
                        };
                        double magnitude = Math.sqrt(Math.pow(direction[0], 2) + Math.pow(direction[1], 2));
                        double[] unitVector = new double[] {
                                direction[0] / magnitude,
                                direction[1] / magnitude
                        };

                        lamp = new Circle(
                                lastBreakPoint.x() - unitVector[0] * trafficLightDistance,
                                lastBreakPoint.y() - unitVector[1] * trafficLightDistance,
                                5
                        ); // position with slight offset
                        connection.setLight(lamp);

                        // adding squares to the map to make it more realistic


                        roadLayer.getChildren().add(lamp);
                    }

                    boolean isGreen = trafficLight.hasGreen(road);
                    if (isGreen) {
                        lamp.setFill(Color.LIGHTGREEN);
                    } else {
                        lamp.setFill(Color.RED);
                    }
                }
            }
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
