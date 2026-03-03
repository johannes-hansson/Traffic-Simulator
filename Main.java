import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox; // vertical elements
import javafx.stage.Modality; // how the popup acts, like being infront the other window
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {

        // create popup window
        Stage popup = new Stage(); // new window
        VBox popupRoot = new VBox(10); // vertical layout with 10 pixels between elements
        popupRoot.setStyle("-fx-padding: 20;");
        Button startButton = new Button("Start simulation");
        popupRoot.getChildren().add(startButton);

        Scene popupScene = new Scene(popupRoot, 200, 100);
        popup.setTitle("Traffic simulator");
        popup.setScene(popupScene);
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.show();


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
    }







    /*
    public static void main(String []args) throws InterruptedException {
        Simulation sim = new Simulation();
        sim.setTickSpeedMs(100);

        sim.addUpdateListener(s -> System.out.println("tick = " + s.getTick()));

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
