package parkinglot;

// Each floor has multiple parking spots.
// Spots are of different types (car, bike, truck).
// A spot can be occupied or free.
// A vehicle can be assigned to a spot.
// A vehicle can be removed from a spot.
public class ParkingSpot {
    private String spotId;
    private VehicleType supportedVechileType;
    private Vehicle currentVechicle;

    public ParkingSpot(String spotId,VehicleType supportedVechileType){
        this.spotId=spotId;
        this.supportedVechileType=supportedVechileType;
        this.currentVechicle=null;
    }

    public Boolean isAvailable(){return currentVechicle==null;}
    public Boolean canPark(Vehicle vehicle){
        return isAvailable() && supportedVechileType == vehicle.getvehicleType();
    }
    public Boolean assignVehicle(Vehicle vehicle){
        if(!canPark(vehicle)) {
            return false;
        }
        this.currentVechicle=vehicle;
        return true;
    }
    public Vehicle removeVehicle(){
        Vehicle removeVehicle=currentVechicle;
        currentVechicle=null;
        return removeVehicle;
    }
    
    //We are intentionally hiding the internal state of ParkingSpot.
    // currentVechicle is coming from somewhere else thats why we are not creating getters for that 
    public String getSpotId(){
        return spotId;
    }
    public VehicleType getSupportedVechileType(){
        return supportedVechileType;
    }
}
