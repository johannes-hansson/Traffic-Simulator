import javafx.application.Platform;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class View implements SimulationUpdateListener {

    private Pane root; // drawing surface

    public View(Pane root) {
        this.root = root;
    }

    @Override
    public void onUpdate(Simulation simulation) {

        Platform.runLater(() -> {

            root.getChildren().clear(); // behövs???

            Map map = simulation.getMap(); // get map from simulation

            ArrayList<Road> roads = map.getRoads(); // get all roads

            for (Road road : roads) { // draw each road via roadrender
                List<Vehicle> vehicles = road.getVehicles();

                RoadRender render = road.getRoadRender();
                render.draw(root, vehicles); // draws between the breakpoints
            }

            // here we can add drawing cars and traffic lights etc
        });
    }
}
