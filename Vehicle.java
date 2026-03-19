//import java.awt.*;
import java.util.*;

import javafx.scene.shape.Rectangle;

/** Base class for all vehicle agents in the simulation.
 * Stores immutable vehicle properties (type parameters) and mutable state such as
 * current position and velocity.
 * Subclasses (e.g., Car, Bus, Truck) typically configure different VehicleProperties */
public class Vehicle {

    private class Turn {
        private Road from;
        private Road to;

        public Turn(Road from, Road to) {
            this.from = from;
            this.to = to;
        }

        public Road fromRoad() {
            return this.from;
        }

        public Road toRoad() {
            return this.to;
        }

        public void setToRoad(Road road) {
            this.to = road;
        }
    };

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

        public Road getTurnDecision(Road from, List<Road> possibleTurns) {
            if (possibleTurns.isEmpty()) {
                return null;
            }

            // Find any previously planned turns for the road
            Turn existingTurnDecision = null;
            for (Turn decision : this.plannedTurns) {
                if (decision.fromRoad() == from) {
                    existingTurnDecision = decision;
                    break;
                }
            }

            if (existingTurnDecision == null) {
                Road decidedRoad = this.chooseRoad(possibleTurns);
                this.plannedTurns.add(new Turn(from, decidedRoad));
                return decidedRoad;
            }

            // Check that the planned turn is possible
            for (Road possibleTurn : possibleTurns) {
                if (existingTurnDecision.toRoad() == possibleTurn) {
                    return existingTurnDecision.toRoad();
                }
            }

            // If the planned turn was not possible, replan it
            existingTurnDecision.setToRoad(this.chooseRoad(possibleTurns));
            return existingTurnDecision.toRoad();
        }

        // Called by VehicleMovement when it executes a turn from a road
        // Removes the turn decision related to that road to free its memory usage
        // and to allow for another turn to be chosen the next time
        public void onTurnedFromRoad(Road from) {
            this.plannedTurns.removeIf(turnDecision -> {
                return (turnDecision.fromRoad() == from);
            });
        }
    }

    private VehicleProperties properties;
    private RoadPosition position;
    private int velocity;
    private LaneChangeDecision laneChangeDecision;
    private PathPlanner pathPlanner;
    private Rectangle graphic;

    //constructor
    public Vehicle(VehicleProperties properties, RoadPosition position, int velocity){
        this.properties = properties;
        this.position = position;
        this.velocity = velocity;
        this.laneChangeDecision = LaneChangeDecision.STRAIGHT;
        this.pathPlanner = new PathPlanner();
    }

    public Road chooseRoad(Road from, ArrayList<Road> possibleTurns) {
        return this.pathPlanner.getTurnDecision(from, possibleTurns);
    }

    public void onTurnedFromRoad(Road from) {
        this.pathPlanner.onTurnedFromRoad(from);
    }

    public LaneChangeDecision getLaneChangeDecision() {
        return this.laneChangeDecision;
    }

    public void setLaneChangeDecision(LaneChangeDecision decision) {
        this.laneChangeDecision = decision;
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

    public void setGraphic(Rectangle r){
        this.graphic = r;
    }

    public Rectangle getGraphic(){
        return graphic;
    }

}
