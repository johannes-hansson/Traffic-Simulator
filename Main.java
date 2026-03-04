/*
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox; // vertical elements
import javafx.stage.Modality; // how the popup acts, like being infront the other window
import javafx.stage.Stage;
import javafx.geometry.Pos; // positions

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {

        // create popup window
        Stage popup = new Stage(); // new window
        VBox popupRoot = new VBox(20); // vertical layout with 10 pixels between elements
        popupRoot.setAlignment(Pos.BASELINE_CENTER); // centre the button in the window
        Button startButton = new Button("Start simulation");
        popupRoot.getChildren().add(startButton);


        Scene popupScene = new Scene(popupRoot, 800, 600);
        popup.setTitle("Traffic simulator");
        popup.setScene(popupScene);
        popup.initModality(Modality.APPLICATION_MODAL); // so you have to press the button before the main window opens
        popup.show();

        // main window
        Pane root = new Pane(); // create new stage
        Simulation simulation = new Simulation(); // create simulation
        View view = new View(root);// create view, connect too root
        simulation.addUpdateListener(view); // add view as listener to simulation

        startButton.setOnAction(e -> {
            popup.close(); // close popup when pressing button
            showSimulationWindow(primaryStage, root, simulation, view);
        });
    }
    
    private void showSimulationWindow (Stage stage, Pane root, Simulation simulation, View view) {
        view.onUpdate(simulation);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Traffic simulator demo");
        stage.setScene(scene);
        stage.show();

        simulation.setTickSpeedMs(100);
        simulation.start();
    }

    public static void main (String[]args) {
        launch(args); // start javafx
    }
}
*/

import java.util.ArrayList;

public class Main {
    public static void main(String []args) throws InterruptedException {
        Map map = new Map();
        VehicleMovement movement = new VehicleMovement();
        VehicleBehaviour behavior = new VehicleBehaviour();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Road> roads = map.getRoads();

        VehicleProperties properties = new VehicleProperties(10, 1, 1, VehicleColor.Red);
        VehicleProperties properties2 = new VehicleProperties(30, 2, 1, VehicleColor.blue);
        RoadPosition position = new RoadPosition(roads.get(0), 0, 0);
        RoadPosition position2 = new RoadPosition(roads.get(1), 0, 0);

        Vehicle vehicle = new Vehicle(properties, position, 0);
        Vehicle vehicle2 = new Vehicle(properties2, position2, 0);
        roads.get(0).enterVehicle(vehicle, 0, 0);
        roads.get(1).enterVehicle(vehicle2, 0, 0);
        vehicles.add(vehicle);
        vehicles.add(vehicle2);

        for (int i=0; i<100; i++) {
            behavior.process(vehicles);
            movement.process(vehicles);
        }
    }
}


