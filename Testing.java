/*
import static org.junit.Assert.*;    //imports JUnits assertion methods
import org.junit.Test;     //imports the @Test anotations
import org.junit.Before;   //import for before and after annotations
import org.junit.After;
import java.util.ArrayList;

//make sure JUnit is downloaded to your lib
//With vscode that has "Test Runner for Java" installed -> right click on a function name -> press source action -> generate tests -> enable test libraries -> JUnit 

public class Testing {
    
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private ArrayList<Vehicle> vehicles;
    private VehicleProperties properties;   //maxVelocity, acceleration, size, VehicleColor color
    private RoadPosition pos;   //road cell lane
    private Road road; 

    @Before //each test
    void setUp(){
        VehicleProperties properties = new VehicleProperties(10, 1, 1, VehicleColor.Red);
        Node node = null; 
        Road road = new Road(node, 20, 1);// Node endNode, int length, int laneCount

        RoadPosition pos1 = new RoadPosition();
        RoadPosition pos2 = new RoadPosition(
            pos1.road(), 
            pos1.cell()+2, 
            pos1.lane()
        );


        Vehicle vehicle1 = new Vehicle(properties, pos1, 5);
        Vehicle vehicle2 = new Vehicle(properties, pos2, 3);


        for(int i=1; i<5; i++){
        Vehicle vehicle = new Vehicle(properties, pos, 5);
        vehicles.add(vehicle);
        //assertEquals( )
        }

    }

    @After
    void destroy(){
        for (Vehicle vehicle : vehicles){
        vehicle = null;
        }
    }

    @Test
    void testAccelerate(){
    }

    @Test
    void testDeaccelerate(){
    }


}
*/

