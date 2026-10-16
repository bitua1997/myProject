package parkinglot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkinglot.fee.FeeStrategy;

// | Class            | Responsibility                         |
// | ---------------- | -------------------------------------- |
// | `Vehicle`        | Represents a vehicle                   |
// | `ParkingSpot`    | Knows how to occupy/free itself        |
// | `ParkingFloor`   | Manages spots on one floor             |
// | `Ticket`         | Stores parking information             |
// | **`ParkingLot`** | Coordinates the entire parking process |

// A class should own only the data that naturally belongs to it.
public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private Map<String,Ticket> tickets;
    private int ticketCounter;
    private FeeStrategy feeStrategy;

    public ParkingLot(FeeStrategy feeStrategy){
        this.parkingFloors= new ArrayList<>();
        this.tickets= new HashMap<>();
        this.ticketCounter=1;
        this.feeStrategy = feeStrategy;
    }
    
    //addFloor()
    public void addFloor(ParkingFloor parkingFloor){
        parkingFloors.add(parkingFloor);
    }
    //parkVehicle
    public Ticket parkVehicle(Vehicle vehicle)
    {
       for(ParkingFloor floor : parkingFloors)
        {
            ParkingSpot allocatedSpot= floor.parkVehicle(vehicle);
            if(allocatedSpot != null){
                //tkt generation
                String ticketId= generateTicketId();

                Ticket ticket = new Ticket(ticketId, 
                                           vehicle, 
                                           floor.getFloorNumber(), 
                                           allocatedSpot.getSpotId(),
                                           LocalDateTime.now() );
                tickets.put(ticketId,ticket);
                return ticket;                                     
            }
        } 
        return null;
    }
    //unparkVehicle
    public Vehicle unparkVehicle(String ticketId){
        Ticket ticket= tickets.get(ticketId);
        if(ticket == null){
            return null;
        }
        double fee=feeStrategy.calculateFee(ticket,LocalDateTime.now());
        System.out.println("Parking fee : "+fee);
        for(ParkingFloor floor : parkingFloors){
            if(floor.getFloorNumber()==ticket.getFloorNumber()){
                Vehicle vehicle= floor.unparkVehicle(ticket.getSpotId());
                tickets.remove(ticketId);
                return vehicle;
            }
        }
        return null;
    }

    private String generateTicketId(){
        return "T"+ticketCounter++;
    }
    // public List <ParkingFloor> getParkingFloors(){
    //     return parkingFloors;
    // }
    // public Map<String,Ticket> getTicket(){
    //     return tickets;
    // }

}
