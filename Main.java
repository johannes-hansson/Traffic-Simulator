import java.util.ArrayList;
import java.util.Random;
//import java.util.random.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox; // vertical elements
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality; // how the popup acts, like being infront the other window
import javafx.stage.Stage;
import javafx.geometry.Pos; // positions
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // create popup window
        Stage popup = new Stage(); // new window
        VBox popupRoot = new VBox(5); // vertical layout with 10 pixels between elements
        popupRoot.setAlignment(Pos.BASELINE_CENTER); // centre the elements in the window

        // create main window
        StackPane root = new StackPane(); // create new stage

        Pane roadLayer = new Pane(); // layer for roads
        Pane vehicleLayer = new Pane(); // layer for vehicles
        Pane uiLayer = new Pane();// Layer for the user interface, buttons

        root.getChildren().addAll(roadLayer, vehicleLayer, uiLayer);


        Simulation simulation = new Simulation(); // create simulation
        View view = new View(roadLayer, vehicleLayer);// create view, connect too root
        SimulationStatistics statistics = new SimulationStatistics();

        simulation.addUpdateListener(view); // add view as listener to simulation
        simulation.addUpdateListener(statistics);


        // create buttons for popup
        Button startButton = new Button("Start simulation");
        startButton.setDefaultButton(true);
        Button cancelButton1 = new Button("Cancel");

        // choose amount of cars
        Label chooseVehicles = new Label("How many vehicles should participate in the simulation?");
        Label vehicleLimit = new Label("Write a number between 0 and 1500");
        TextField numCarsField = new TextField();

        chooseVehicles.setAlignment(Pos.CENTER);
        vehicleLimit.setAlignment(Pos.CENTER);
        numCarsField.setAlignment(Pos.CENTER);
        // add everything to the popup window
        popupRoot.getChildren().addAll(chooseVehicles, vehicleLimit, numCarsField, startButton, cancelButton1);

        // create buttons for main stage
        Button stopButton = new Button("Stop simulation");
        Button pauseButton = new Button("Pause");
        Button exitButton1 = new Button("Exit program");

        javafx.scene.layout.HBox PauseStopButtons = new javafx.scene.layout.HBox(10);
        PauseStopButtons.setAlignment(Pos.TOP_RIGHT);
        PauseStopButtons.getChildren().addAll(pauseButton, stopButton, exitButton1);

        Button fastMode = new Button("Fast");
        Button normalMode = new Button("Normal");
        Button slowMode = new Button("Slow");

        Label speedLabel = new Label("Choose speed: ");
        javafx.scene.layout.HBox speedButtonsRow = new javafx.scene.layout.HBox(10);
        speedButtonsRow.setAlignment(Pos.TOP_LEFT);
        speedButtonsRow.getChildren().addAll(speedLabel, slowMode, normalMode, fastMode);

        // add button
        uiLayer.getChildren().addAll(PauseStopButtons, speedButtonsRow);

        PauseStopButtons.setLayoutX(930); // set the buttons on the pane
        PauseStopButtons.setLayoutY(0);

        speedButtonsRow.setLayoutX(10);
        speedButtonsRow.setLayoutY(0);



        // button behaviors:
        EventHandler<ActionEvent> pressStart = new EventHandler<ActionEvent>() { // behavior for start button
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int nCars = Integer.parseInt(numCarsField.getText());

                    if(nCars < 1 || nCars > 1500){ // check if the input is within given limits
                        Alert amountAlert = new Alert(Alert.AlertType.ERROR);
                        amountAlert.setHeaderText("Input number not within given limits");
                        amountAlert.setContentText("Please write a number between 0 and 1500");
                        amountAlert.showAndWait();
                        return;
                    }

                    simulation.setMap(new Map());
                    simulation.setVehicleMovement(new VehicleMovement());
                    simulation.setVehicleBehaviour(new VehicleBehaviour());

                    popup.close();// close popup when pressing button
                    simulation.createVehicles(nCars);
                    showSimulationWindow(primaryStage, root, simulation, view); // start simulation

                } catch (NumberFormatException e) { // check if the input is a number, otherwise alert
                    Alert typeAlert = new Alert(Alert.AlertType.ERROR);
                    typeAlert.setHeaderText("Input is invalid");
                    typeAlert.setContentText("Please write a number between 0 and 1500");
                    typeAlert.showAndWait();
                }
            }
        };

        EventHandler<ActionEvent> pressCancel1 = new EventHandler<ActionEvent>() { // behavior for cancel on popup
            @Override
            public void handle(ActionEvent actionEvent) {
                popup.close(); // close popup
            }
        };

        EventHandler<ActionEvent> pressExit1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("Do you want to exit the program?");

                if (alert.showAndWait().get() == ButtonType.OK) {
                    simulation.stop();
                    Platform.exit();
                }
            }
        };

        EventHandler<ActionEvent> pressPause = new EventHandler<ActionEvent>() { // pause when pressing pause button
            @Override
            public void handle(ActionEvent actionEvent) {
                if(simulation.paused){
                    simulation.resume();
                }
                else if (simulation.running){
                    simulation.pause();
                };
            }
        };

        EventHandler<ActionEvent> pressSlow = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                simulation.setSpeedMode(Simulation.SpeedMode.SLOW);
            }
        };

        EventHandler<ActionEvent> pressNormal = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                simulation.setSpeedMode(Simulation.SpeedMode.NORMAL);
            }
        };

        EventHandler<ActionEvent> pressFast = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                simulation.setSpeedMode(Simulation.SpeedMode.FAST);
            }
        };


        EventHandler<ActionEvent> pressStop = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                simulation.stop(); // stop simulation

                // create popup window
                Stage statsStage = new Stage();
                VBox statsRoot = new VBox(10);
                statsRoot.setAlignment(Pos.CENTER);

                Label statsLabel = new Label("Simulation statistics:");
                statsLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;"); // bigger text for title

                TextArea statsArea = new TextArea(); // create text are for statistics
                statsArea.setPrefSize(250, 160);

                // change these stats later
                SimulationStatistics.TickStats latest = statistics.getLatest();

                statsArea.setText(
                        "Amount of ticks during simulation: " + latest.tick() + "\n" +
                        "Amount of vehicles: " + latest.vehicleCount() + "\n" +
                        "Average velocity: " + String.format("%.2f",latest.avgVelocity()) + "\n" +
                        "Max velocity: " + latest.maxVelocity() + "\n" +
                        "Amount of stopped vehicles: " + latest.stoppedCount() + "\n" +
                        "Amount of jammed vehicles: " + latest.jammedCount() + "\n" +
                        "Amount of vehicles that had collision risks: " + latest.collisionRiskCount() + "\n" +
                        "Average gap between vehicles: " + String.format("%.2f",latest.avgGap())
                );

                statsArea.setEditable(false); // make so you cant write in teh box

                Button restartButton = new Button("Restart program");
                Button exitButton = new Button("Exit");

                // this makes the buttons line up nest to each other
                javafx.scene.layout.HBox buttonRow = new javafx.scene.layout.HBox(20);
                buttonRow.setAlignment(Pos.CENTER);
                buttonRow.getChildren().addAll(restartButton, exitButton);

                statsRoot.getChildren().addAll(statsLabel, statsArea, buttonRow);

                Scene statsScene = new Scene(statsRoot, 500, 250);
                statsStage.setScene(statsScene);
                statsStage.setTitle("Stopped simulation");

                statsStage.initModality(Modality.APPLICATION_MODAL);
                statsStage.show();

                // restart program
                EventHandler<ActionEvent> pressRestart = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        statsStage.close(); // close stats window
                        primaryStage.close(); // close simulation window

                        Platform.runLater(() -> {
                            try {
                                new Main().start(new Stage()); // start program again
                            } catch (Exception e) {
                                System.err.println("Error: " + e.getMessage()); // in case of error at restart, print error message
                            }
                        });
                    }
                };

                EventHandler<ActionEvent> pressFinalExit = new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        simulation.stop();
                        Platform.exit();
                    }
                };

                // restart program
                restartButton.setOnAction(pressRestart);
                // exit program
                exitButton.setOnAction(pressFinalExit);
            }
        };

        startButton.setOnAction(pressStart); // start pressStart when button is pressed
        cancelButton1.setOnAction(pressCancel1); // start pressCancel1 when ca

        slowMode.setOnAction(pressSlow);
        normalMode.setOnAction(pressNormal);
        fastMode.setOnAction(pressFast);

        stopButton.setOnAction(pressStop);
        pauseButton.setOnAction(pressPause);
        exitButton1.setOnAction(pressExit1);


        // Start popup window
        Scene popupScene = new Scene(popupRoot, 700, 500);
        popup.setTitle("Traffic simulator");
        popup.setScene(popupScene);
        popup.initModality(Modality.APPLICATION_MODAL); // so you have to press the button before the main window opens
        popup.show();


    }

    // function that starts the simulation window
    private void showSimulationWindow(Stage stage, Pane root, Simulation simulation, View view) {
        //view.onUpdate(simulation);

        Scene scene = new Scene(root, 1200,800);
        stage.setTitle("Traffic simulator demo");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(e-> { // makes the simulation stop when pressing key SPACE
            if (e.getCode() == KeyCode.SPACE){
                if(simulation.paused){
                    simulation.resume();
                }
                else if (simulation.running){
                    simulation.pause();
                };
            }

        } );


        simulation.setTickSpeedMs(100);
        simulation.start();
    }

    public static void main(String[] args) {
        launch(args); // start javafx
    }
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

    }

    }
}*/

