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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox; // vertical elements
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

        //Pane simulationPane = new Pane();


        Simulation simulation = new Simulation(); // create simulation
        View view = new View(roadLayer, vehicleLayer);// create view, connect too root
        simulation.addUpdateListener(view); // add view as listener to simulation
        // VBox rootLayout = new VBox(10);


        // create buttons for popup
        Button startButton = new Button("Start simulation");
        Button cancelButton1 = new Button("Cancel");

        // choose amount of cars
        Label chooseVehicles = new Label("How many vehicles should participate in the simulation?");
        TextField numCarsField = new TextField();
        numCarsField.setPromptText("Write a number between 500 and 1000");
        // add everything to the popup window
        popupRoot.getChildren().addAll(chooseVehicles, numCarsField, startButton, cancelButton1);

        // create buttons for main stage
        Button stopButton = new Button("Stop simulation");
        //stopButton.setStyle("-fx-padding: 5;");

        Button fastMode = new Button("Fast");
        Button normalMode = new Button("Normal");
        Button slowMode = new Button("Slow");

        Label speedLabel = new Label("Choose speed: ");
        javafx.scene.layout.HBox buttonsRow = new javafx.scene.layout.HBox(10);
        buttonsRow.setAlignment(Pos.TOP_LEFT);
        //buttonsRow.setStyle("-fx-padding: 5;");
        buttonsRow.getChildren().addAll(speedLabel, slowMode, normalMode, fastMode);

        // add button
        uiLayer.getChildren().addAll(stopButton, buttonsRow);

        stopButton.setLayoutX(1100);
        stopButton.setLayoutY(0);

        buttonsRow.setLayoutX(5);
        buttonsRow.setLayoutY(0);



        // button behaviors:
        EventHandler<ActionEvent> pressStart = new EventHandler<ActionEvent>() { // behavior for start button
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int nCars = Integer.parseInt(numCarsField.getText());

                    simulation.setMap(new Map());
                    simulation.setVehicleMovement(new VehicleMovement());
                    simulation.setVehicleBehaviour(new VehicleBehaviour());

                    popup.close();// close popup when pressing button
                    createVehicles(simulation, nCars, vehicleLayer);
                    showSimulationWindow(primaryStage, root, simulation, view); // start simulation

                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number");
                }
            }
        };

        EventHandler<ActionEvent> pressCancel1 = new EventHandler<ActionEvent>() { // behavior for cancel on popup
            @Override
            public void handle(ActionEvent actionEvent) {
                popup.close(); // close popup
            }
        };

        EventHandler<ActionEvent> pressExit = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setHeaderText("You're about to exit!");
                alert.setContentText("Do you want to exit the simulation?");

                if (alert.showAndWait().get() == ButtonType.OK) {
                    simulation.stop();
                    Platform.exit();
                }
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
                statsArea.setPrefSize(300, 100);

                // change these stats later
                statsArea.setText(
                        "Simulation finished\n" + "Ticks: " + simulation.getTick() + "\n" + "Vehicles: " + simulation.getVehicles().size()
                );
                statsArea.setEditable(false); // make so you cant write in teh box

                Button restartButton = new Button("Restart program");
                Button exitButton = new Button("Exit");

                // this makes the buttons line up nest to each other
                javafx.scene.layout.HBox buttonRow = new javafx.scene.layout.HBox(20);
                buttonRow.setAlignment(Pos.CENTER);
                buttonRow.getChildren().addAll(restartButton, exitButton);

                statsRoot.getChildren().addAll(statsLabel, statsArea, buttonRow);

                Scene statsScene = new Scene(statsRoot, 600, 200);
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

                // restart program
                restartButton.setOnAction(pressRestart);
                // exit program
                exitButton.setOnAction(pressExit);
            }
        };

        startButton.setOnAction(pressStart); // start pressStart when button is pressed
        cancelButton1.setOnAction(pressCancel1); // start pressCancel1 when ca

        slowMode.setOnAction(pressSlow);
        normalMode.setOnAction(pressNormal);
        fastMode.setOnAction(pressFast);
        stopButton.setOnAction(pressStop);


        // Start popup window
        Scene popupScene = new Scene(popupRoot, 800, 600);
        popup.setTitle("Traffic simulator");
        popup.setScene(popupScene);
        popup.initModality(Modality.APPLICATION_MODAL); // so you have to press the button before the main window opens
        popup.show();


    }

    // function that starts the simulation window
    private void showSimulationWindow(Stage stage, Pane root, Simulation simulation, View view) {
        //view.onUpdate(simulation);

        Scene scene = new Scene(root, 1200,1000);
        stage.setTitle("Traffic simulator demo");
        stage.setScene(scene);
        stage.show();
        //view.onUpdate(simulation);

        simulation.setTickSpeedMs(100);
        simulation.start();
    }

    private void createVehicles(Simulation simulation, int numberCars, Pane simulationPane) {

        Random rand = new Random();
        ArrayList<Road> roads = simulation.getMap().getRoads();
        System.out.println("Number of roads: " + roads.size());

        for (int i = 0; i < numberCars; i++) {

            Road road = roads.get(rand.nextInt(roads.size())); // random road
            //int cell = rand.nextInt(road.getLength());
            int lane = rand.nextInt(road.getLanes());// random lane on cell on road

            ArrayList<BreakPoint> points = road.getRoadRender().getBreakPoints();
            if (points.size() < 2) continue; // om det inte finns tillräckligt med punkter, hoppa över

            int maxCell = points.get(points.size() - 1).cell(); // högsta cell på vägen
            int cell = rand.nextInt(maxCell); // säkerställer att cellen är inom breakpoints

            RoadPosition startPosition = new RoadPosition(road, lane, cell);
            VehicleProperties properties = new VehicleProperties(10, 1, 1);
            Vehicle car = new Vehicle(properties, startPosition, 0);


            //System.out.println("Randomnum: " + cell + " " + lane + "Road name: " + road.name);

            BreakPoint p1 = points.get(0);
            BreakPoint p2 = points.get(1);

            for (int j = 0; j < points.size() - 1; j++) {
                if (cell >= points.get(j).cell() && cell <= points.get(j + 1).cell()) {
                    p1 = points.get(j);
                    p2 = points.get(j + 1);
                    break;
                }
            }

            //double t = (double)(cell - p1.cell()) / (p2.cell() - p1.cell());
            double cellDiff = (p2.cell() - p1.cell());
            double t = 0;

            if (cellDiff != 0) {
                t = (double) (cell - p1.cell()) / cellDiff;
            }

            t = Math.max(0, Math.min(1, t));

            double xPos = p1.x() + (p2.x() - p1.x()) * t;
            double yPos = p1.y() + (p2.y() - p1.y()) * t;

            // the visual rectangle


            Rectangle carRectangle = new Rectangle(4, 8);
            carRectangle.setFill(Color.RED);

            carRectangle.setX(xPos - carRectangle.getWidth() / 2);
            carRectangle.setY(yPos - carRectangle.getHeight() / 2);

            // place car att right position based on breakpoints
            //BreakPoint position = road.getRoadRender().getBreakPoints().get(cell);

            //BreakPoint position = road.getRoadRender().getBreakPoints().get(cell % road.getRoadRender().getBreakPoints().size());

            // carRectangle.setX(position.x() - carRectangle.getWidth()/2); // so it gets in the middle of the cell
            // carRectangle.setY(position.y() - carRectangle.getHeight()/2); // so it gets in the middle of the cell

            //carRectangle.setTranslateX(xPos);
            // carRectangle.setTranslateY(yPos);
            //System.out.println("Position: " + xPos + " " + yPos);

            car.setGraphic(carRectangle); // connect to the graphics

            // If the chosen cell is occupied, the vehicle is never created
            // This needs to be changed to find a new position instead
            if (!road.isOccupied(lane, cell)) {
                simulation.addVehicle(car, startPosition); // add car
                Platform.runLater(() -> {
                    simulationPane.getChildren().add(carRectangle); // add rectangle for car
                });
            }

        }
        System.out.println("vehicles created: " + numberCars);


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

