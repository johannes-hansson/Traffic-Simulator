import java.util.Random;

import Road.ScanResult;

public class VehicleBehaviour {
    
    //public List<LaneSwitchDecision> computeLaneSwitches() {
   //     return null;
   // }

    public int accelerate(Vehicle vehicle) { //Acceleration: vi <- min (vi+1,vmax)
        VehicleProperties properties = vehicle.getProperties();
        int prevVelocity = vehicle.getVelocity();
        int newVelocity = prevVelocity + properties.acceleration(); 
    
        if(newVelocity < properties.maxVelocity()){ //acceleration cant pass over max speed of vehicle
            return newVelocity;}

        else{
            return prevVelocity;} 
    }
 
    public int deaccelerate(Vehicle vehicle) { //deaccelerate when vehicles in front
        int velocity = vehicle.getVelocity();
        RoadPosition position = vehicle.getPosition();
        Road road = position.road();
        int lane = road.getLanes();

        //scan the road (get the free gap between in front of vehicle/intersection)
        Road.ScanResult scanResult = road.scanCells(lane, position.cell(), velocity, false);
        velocity = scanResult.distance();
       
        //the new velocity is v = min(v, gap) where gap is the free cells until next vehicle__
        return velocity;
    }

    public int randomisation(Vehicle vehicle, double p){
        int velocity = vehicle.getVelocity();
        Random random = new Random();
        double randomDouble = random.nextDouble();  //generates a random double between 0.0 and 1.0

        if((velocity > 1)&&(0<=p)&&(p<=1)){     
            if(randomDouble <= p){              //Bernoulli 
                velocity--; //velocity gets less by one unit
            }
        }
        return velocity;
    }
    
    public int computeVelocities(Vehicle vehicle){
        int velocity; 

    /// Nagel-schreckenberg-model
    //1. Acceleration
        velocity = accelerate(vehicle); 
        vehicle.setVelocity(velocity);

    //2. Deacceleration
        velocity = deaccelerate(vehicle); 
        vehicle.setVelocity(velocity);

    //3. Randomization
        double p = 0.5;    //50% chance for vehicle to slow down by one unit
        velocity = randomisation(vehicle, p);
        vehicle.setVelocity(velocity);

    return velocity;
    }
        
    /* Nagel-schreckenberg-model
            Every car agent i follows the rules: 
        1. Acceleration: vi <- min (vi+1,vmax), 
        2. Deceleration to avoid accidents: vi <- min (vi,gap), 
        3. Randomisation: with a certain probability p do  
         vi <- max (vi-1,0) 
        4. Movement: xi <- xi+vi  */

    

}
