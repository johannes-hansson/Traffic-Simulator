//import java.awt.*;
import java.util.*;

import javafx.scene.shape.Rectangle;

/** Base class for all vehicle agents in the simulation.
 * Stores immutable vehicle properties (type parameters) and mutable state such as
 * current position and velocity.
 * Subclasses (e.g., Car, Bus, Truck) typically configure different VehicleProperties */
public class Vehicle {

    private record Turn(Node node, Road road){};

    private class PathPlanner {

        private Random turnRandomizer;
        private ArrayList<Turn> plannedTurns;

        public PathPlanner() {
            this.turnRandomizer = new Random();
            this.plannedTurns = new ArrayList<>();
        }

        private Road chooseRoad(List<Road> possibleTurns) {
            return possibleTurns.get(this.turnRandomizer.nextInt(possibleTurns.size()));
        }

        public Road getTurnDecision(Node node, List<Road> possibleTurns) {
            if (possibleTurns.isEmpty()) {
                return null;
            }

            // Find any previously planned turns for the node
            for (Turn decision : this.plannedTurns) {
                if (decision.node == node) {
                    for (Road possibleTurn : possibleTurns) {
                        if (decision.road == possibleTurn) {
                            return decision.road;
                        }
                    }
                }
            }

            // If there were no planned decisions, create one and return it
            Road road = this.chooseRoad(possibleTurns);
            this.plannedTurns.add(new Turn(node, road));
            return road;
        }

        public void clearDecisions() {
            this.plannedTurns.clear();
        }
    }

    private VehicleProperties properties;
    private RoadPosition position;
    private int velocity;
    private PathPlanner pathPlanner;
    private Rectangle graphic;

    //constructor
    public Vehicle(VehicleProperties properties, RoadPosition position, int velocity){
        this.properties = properties;
        this.position = position;
        this.velocity = velocity;
        this.pathPlanner = new PathPlanner();
    }

    public Road chooseRoad(Node node, ArrayList<Road> roads) {
        return this.pathPlanner.getTurnDecision(node, roads);
    }

    public void clearTurnDecisions() {
        this.pathPlanner.clearDecisions();
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public VehicleProperties getProperties() {
        return this.properties;
    }

    public void setPosition(RoadPosition position) {
        this.position = position;
    }

    public RoadPosition getPosition() {
        return this.position;
    }

    public void displayDetailsVehicle(){
        System.out.println("Vehicle details: ");
        System.out.println("Velocity: " + velocity);
        System.out.println("Road: " + this.position.road());
    }

    public void setGraphic(Rectangle r){
        this.graphic = r;
    }

    public Rectangle getGraphic(){
        return graphic;
    }

}
