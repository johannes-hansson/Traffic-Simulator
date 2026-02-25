import java.util.ArrayList;

public class VehicleBehaviour {
    
    public ArrayList<LaneSwithDecision> computeLaneSwitches() {
        return null;
    }

    public int accelerate(Vehicle vehicle) { //Acceleration: vi <- min (vi+1,vmax)
        VehicleProperties properties = vehicle.getProperties();
        int prevVelocity = vehicle.getVelocity();
        int newVelocity = prevVelocity + properties.acceleration(); 
    
        if(newVelocity < properties.maxVelocity()){ //acceleration cant pass over max speed of vehicle
            return newVelocity;}

        else{
            return prevVelocity;} 
    }

    public int deaccelerate(Vehicle vehicle, LocationalMap locationMap) { //deaccelerate when vehicles in front
        
        int velocity = vehicle.getVelocity();
        RoadPosition position = vehicle.getPosition();

        Road road = position.road();
        int roadLength = road.getLength();
        int roadDistanceLeft = roadLength - position.cell();
        if (velocity > roadDistanceLeft) {      //check so speed of vehicle to move is not longer than roadDistance left
            velocity = roadDistanceLeft;
        }

        velocity = locationMap.scanAheadOf(position, velocity); 
        //check if there is vehicle ahead and if can go the speed it wants
        //the new velocity is v = min(v, gap) where gap is the free cells between obstacles
        return velocity;
    }
            /* Nagel-schreckenberg-model
            Every car agent i follows the rules: 
        1. Acceleration: vi <- min (vi+1,vmax), 
        2. Deceleration to avoid accidents: vi <- min (vi,gap), 
        3. Randomisation: with a certain probability p do  
         vi <- max (vi-1,0) 
        4. Movement: xi <- xi+vi  */

    

    public void computeLaneSwitches(Vehicle[] vehicles, LocationalMap locationalMap, 
                LaneSwitchDecision[] laneSwitchDecisions){
                    
                
                }
    

}
