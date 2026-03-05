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
    private void showSimulationWindow (Stage stage, Pane root, Simulation simulation, View view){
        view.onUpdate(simulation);

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Traffic simulator demo");
        stage.setScene(scene);
        stage.show();

        simulation.setTickSpeedMs(100);
        simulation.start();
    }

        public static void main (String[]args){
            launch(args); // start javafx
        }








/*


public class Main{
    public static void main(String []args) throws InterruptedException {
        Map map = new Map();
        VehicleMovement movement = new VehicleMovement();
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Road> roads = map.getRoads();

        VehicleProperties properties = new VehicleProperties(10, 1, 1, VehicleColor.Red);
        RoadPosition position = new RoadPosition(roads.get(0), 0, 0);
        RoadPosition position2 = new RoadPosition(roads.get(1), 0, 0);

        Vehicle vehicle = new Vehicle(properties, position, 10);
        Vehicle vehicle2 = new Vehicle(properties, position2, 0);
        roads.get(0).enterVehicle(vehicle, 0, 0);
        roads.get(1).enterVehicle(vehicle2, 0, 0);
        vehicles.add(vehicle);
        vehicles.add(vehicle2);

        for (int i=0; i<100; i++) {
            movement.process(vehicles);
        }

        
        Simulation sim = new Simulation();
        SimulationStatistics stats = new SimulationStatistics();
        sim.setLocationalMap(new LocationalMap());
        sim.setVehicleMovement(new VehicleMovement());
        sim.setVehicleBehaviour(new VehicleBehaviour());
        sim.setMap(new Map());
        Road road = sim.getMap().getRoads().get(0);

        // Demo setup: 2 vehicles
        RoadPosition start = new RoadPosition(road, 10, 0);
        sim.addVehicle(new Car(start, 0, VehicleColor.Red), start);
        RoadPosition start2 = new RoadPosition(road, 8, 0);
        sim.addVehicle(new Car(start2, 3, VehicleColor.blue), start2);

        sim.setTickSpeedMs(100);

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));
        sim.addUpdateListener(stats);

        sim.addUpdateListener(s -> {
            var latest = stats.getLatest();
            if (latest != null && latest.tick() % 5 == 0) { //printing statistics each 5 ticks
                System.out.println(latest);
            }
        });

        sim.addUpdateListener(s -> {
            for (Vehicle v : s.getVehicles()) {
                System.out.println(
                        v.getProperties().color() +
                                " cell=" + v.getPosition().cell() +
                                " vel=" + v.getVelocity()
                );
            }
        });

        sim.start();

        Thread.sleep(350);

        sim.pause();
        int pausedAt = sim.getTick();
        System.out.println("Paused at tick: " + pausedAt);

        Thread.sleep(400);
        System.out.println("Still paused tick: " + sim.getTick());

        sim.resume();
        Thread.sleep(300);

        sim.stop();

        System.out.println("Stopped at tick: " + sim.getTick());

    } */

    }


