import static org.junit.Assert.*;    //imports JUnits assertion methods
import org.junit.Test;     //imports the @Test anotations
import org.junit.Before;   //import for before and after annotations
import org.junit.After;
import java.util.ArrayList;

//make sure JUnit 4 is downloaded to your lib
//With vscode that has "Test Runner for Java" installed -> right click on a function name -> press source action -> generate tests -> enable test libraries -> JUnit 

public class Testing {
    
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private ArrayList<Vehicle> vehicles;
    private VehicleProperties properties;   //maxVelocity, acceleration, size, VehicleColor color
    private RoadPosition pos1;   //road cell lane
    private RoadPosition pos2;
    //private RoadPosition pos3;
    private Road road; 
    private VehicleBehaviour beh;
    //private VehicleMovement move;

    @Before //each test
   public void setUp(){
        beh = new VehicleBehaviour();
        vehicles = new ArrayList<>();

        properties = new VehicleProperties(10, 1, 1);
        Node node = null; 
        road = new Road(node, 20, 1, null, "TestRoad");

        pos1 = new RoadPosition(road, 1, 1);
        pos2 = new RoadPosition(road, 1, 5);
        pos3 = new RoadPosition(road, 1, 4);

        vehicle1 = new Vehicle(properties, pos1, 5);
        vehicle2 = new Vehicle(properties, pos2, 3);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
    }

    @After
    public void destroy(){
        vehicles.clear();
    }

    @Test
    public void testAccelerate(){
        int prev_velocity = vehicle1.getVelocity();
        int newVelocity = beh.accelerate(vehicle1);
        assertTrue(prev_velocity+1 == newVelocity);
    }

    @Test
    public void testDeaccelerate(){ //deaccelerate needs to get its latest update to work
        int prev_velocity = vehicle1.getVelocity();
        int newVelocity = beh.deaccelerate(vehicle1);
        assertTrue(prev_velocity >= newVelocity);
    }

    @Test
    public void testRandomisation(){
        int prev_velocity = vehicle1.getVelocity();
        int newVelocity = beh.randomisation(vehicle1, 0.5);
        assertTrue(prev_velocity-1 ==  newVelocity || prev_velocity == newVelocity);
    }

    @Test 
    public void testMoveVehicle(){
        
    }

}
