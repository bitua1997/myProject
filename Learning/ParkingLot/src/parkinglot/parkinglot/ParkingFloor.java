package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber){
        this.floorNumber=floorNumber;
        this.parkingSpots=new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
    }
    public ParkingSpot getAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots)
        {
            if(spot.canPark(vehicle)){
                return spot;
            }
        }
        return null;
    }
    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot availableSpot = getAvailableSpot(vehicle);
        if(availableSpot==null){
            return null;
        }
        boolean parked= availableSpot.assignVehicle(vehicle);
        if(!parked){
            return null;
        }
        return availableSpot;
    }
    public Vehicle unparkVehicle(String spotId){
        for(ParkingSpot spot : parkingSpots)
        {
            if(spot.getSpotId().equals(spotId)){
                return spot.removeVehicle();
            }
        }
        return null;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }
}
