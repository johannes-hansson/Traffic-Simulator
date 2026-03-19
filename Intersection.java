import java.util.ArrayList;

/** Simple test/dummy node implementation used to build small maps quickly during development.
 * Provides deterministic behaviour for unit tests and early integration tests. */
public class Intersection implements Node {

    private enum TurnDirection {
        LEFT,
        STRAIGHT,
        RIGHT,
    }

    private class Connection {
        Road inRoad;
        Road outRoad;
        int direction;

        public Connection(int direction) {
            this.direction = direction;
        }

        public Road getInRoad() {
            return this.inRoad;
        }

        public Road getOutRoad() {
            return this.outRoad;
        }

        public int getDirection() {
            return this.direction;
        }

        public void setInRoad(Road inRoad) {
            this.inRoad = inRoad;
        }

        public void setOutRoad(Road outRoad) {
            this.outRoad = outRoad;
        }
    }

    private TrafficLight trafficLight;
    private boolean hasTrafficLight;
    private Connection[] connections;
    private double[] position;
    private double width;

    public Intersection(double[] position, double width) {
        this.position = position;
        this.width = width;

        this.connections = new Connection[] {
                new Connection(0),
                new Connection(1),
                new Connection(2),
                new Connection(3),
        };
    }

    public TrafficLight getTrafficLight() {
        return this.trafficLight;
    }

    public void addIncomingRoad(Road incoming, CardinalDirection direction) {
        Connection connection = this.connections[direction.getIntDirection()];
        connection.setInRoad(incoming);

        int numberOfIncomingRoads = 0;
        for (int connectionIndex=0; connectionIndex < this.connections.length; connectionIndex++) {
            if (this.connections[connectionIndex].getInRoad() != null) {
                numberOfIncomingRoads++;
            }
        }

        // If there is more than one incoming road, add a traffic light if one
        // does not already exist
        if (numberOfIncomingRoads > 1 && this.trafficLight == null) {
            this.trafficLight = new TrafficLight(this.connections.length);
            for (int connectionIndex=0; connectionIndex < this.connections.length; connectionIndex++) {
                if (this.connections[connectionIndex].getInRoad() != null) {
                    this.trafficLight.addRoad(this.connections[connectionIndex].getInRoad(), connectionIndex);
                }
            }
            return;
        }

        // Only add the road to the traffic light if this node actually has one
        // Prevents null pointer errors for intersections without signals
        if (this.trafficLight != null){
            this.trafficLight.addRoad(incoming, direction.getIntDirection());
        }
    }

    public void addOutgoingRoad(Road outgoing, CardinalDirection direction) {
        Connection connection = this.connections[direction.getIntDirection()];
        connection.setOutRoad(outgoing);
    }

    private Connection getConnectionFromIncoming(Road incoming) {
        if (incoming == null) {
            return null;
        }

        for (int i = 0; i < this.connections.length; i++) {
            Connection connection = this.connections[i];
            if (connection.getInRoad() == incoming) {
                return connection;
            }
        }
        return null;
    }

    private Connection getConnectionFromOutgoing(Road outgoing) {
        if (outgoing == null) {
            return null;
        }

        for (int i = 0; i < this.connections.length; i++) {
            Connection connection = this.connections[i];
            if (connection.getOutRoad() == outgoing) {
                return connection;
            }
        }

        return null;
    }

    // private Connection getConnectionLeftTo(int index) {
    //     return this.connections[(index + 3) % 4];
    // }

    // private Connection getConnectionRightTo(int index) {
    //     return this.connections[(index + 1) % 4];
    // }

    // private Connection getConnectionAheadOf(int index) {
    //     return this.connections[(index + 2) % 4];
    // }

    private TurnDirection getDirectionOfTurn(Connection from, Connection to) {
        int fromDirection = from.getDirection();
        int toDirection = to.getDirection();

        if ((fromDirection + 1) % 4 == toDirection) {
            return TurnDirection.LEFT;
        }

        if ((fromDirection - 1) % 4 == toDirection) {
            return TurnDirection.RIGHT;
        }

        return TurnDirection.STRAIGHT;
    }

    // Given the entry road, returns a vector containing all roads a car can turn onto
    public ArrayList<Road> getAvailableTurns(Road incoming) {
        Connection connection = this.getConnectionFromIncoming(incoming);
        ArrayList<Road> availableTurns = new ArrayList<>();

        // Check that the incoming road has a connection
        // If not, it is not connected to the intersection
        if (connection == null) return availableTurns;

        int incomingDirection = connection.getDirection();
        for (int direction = 0; direction < this.connections.length; direction++) {
            // U-turns are presumed to be unallowed
            // ignore the outgoing road of the same connection as the incoming
            if (direction == incomingDirection) continue;

            Road outgoing = this.connections[direction].getOutRoad();
            if (outgoing != null) {
                availableTurns.add(outgoing);
            }
        }
        return availableTurns;
    }

    // Given the entry road and a lane, returns a vector containing all roads that
    // can be turned onto from the lane
    public ArrayList<Road> getAvailableTurnsFromLane(Road incoming, int lane) {
        ArrayList<Road> availableTurns = this.getAvailableTurns(incoming);

        // Remove any road that is not accessible from the given lane
        availableTurns.removeIf(outgoing -> {
            int[][] laneMap = this.getLaneMap(incoming, outgoing);
            for (int lanePairIndex = 0; lanePairIndex < laneMap.length; lanePairIndex++) {
                if (laneMap[lanePairIndex][0] == lane) {
                    return false;
                }
            }
            return true;
        });

        return availableTurns;
    }

    public int[][] getLaneMap(Road incoming, Road outgoing) {
        /*
        Lane maps describe the lane connections between an incoming road and an outgoing road.
        They are represented by a set of arrays containing two integers, one for the lane of the incoming
        road and one for the lane of the outgoing road. [[0, 0], [1, 1]] would show a connection between
        lane 0 on the incoming road to lane 0 on the outgoing road, as well as lane 1 on the incoming road
        to lane 1 on the outgoing road.

        For the mock node, these are automatically generated based on the following rules:
            1. If the roads are on opposite sides (going straight), each lane N for the incoming road
               will be connected to lane N for the outgoing road. If one road has more lanes than the other,
               the additional lanes will be ignored.
               ([[0, 0], ..., [N-1, N-1]]) where N is the fewest amount of lanes between the roads.

            2. If the roads make up a right hand turn, only the rightmost (first) lane of the incoming road
               will be connected to the first lane of the outgoing road.
               ([[0, 0]])
            
            3. If the roads make up a left hand turn, only the leftmost (last) lane of the incoming road
               will be connected to the leftmost lane of the outgoing road.
               ([[N-1, M-1]]) where N is the amount of lanes on the incoming road and M is
               the amount of lane on the outgoing road.
        */
        

        Connection incomingConnection = this.getConnectionFromIncoming(incoming);
        Connection outgoingConnection = this.getConnectionFromOutgoing(outgoing);

        // Check that both the incoming and the outgoing road has a connection
        // If not, they are not connected to the intersection
        if (incomingConnection == null || outgoingConnection == null) {
            System.err.println("One or both roads given for a requested lane mapping does not connect to the intersection");
            return new int[][] {};
        }

        int incomingLanes = incoming.getLanes();
        int outgoingLanes = outgoing.getLanes();
        TurnDirection turnDirection = this.getDirectionOfTurn(incomingConnection, outgoingConnection);

        if (turnDirection == TurnDirection.STRAIGHT) {
            int fewestLanesAmount = Math.min(incomingLanes, outgoingLanes);
            int[][] laneMap = new int[fewestLanesAmount][];
            for (int lane = 0; lane < fewestLanesAmount; lane++) {
                laneMap[lane] = new int[] {lane, lane};
            }
            return laneMap;
        }
        if (turnDirection == TurnDirection.RIGHT) return new int[][] {{0, 0}};
        if (turnDirection == TurnDirection.LEFT) return new int[][] {{incomingLanes-1, outgoingLanes-1}};

        return new int[][] {};
    };

    public boolean requestTurn(Road incoming, Road outgoing) {

        // If the intersection has no traffic light,
        // vehicles are always allowed to pass
        if(this.trafficLight == null){
            return true;
        }

        // Otherwise check if the incoming road currently has a green light
        return this.trafficLight.hasGreen(incoming);
    }

    public double[] getPosition() {
        return this.position;
    }

    public double getWidth() {
        return this.width;
    }
}
