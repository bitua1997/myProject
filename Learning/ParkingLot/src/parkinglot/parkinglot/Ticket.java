package parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private int floorNumber;
    private String spotId;
    private LocalDateTime entryTime;

    public Ticket(String ticketId,
                  Vehicle vehicle,
                  int floorNumber,
                  String spotId,
                  LocalDateTime entryTime){
        this.ticketId=ticketId;
        this.vehicle=vehicle;
        this.floorNumber=floorNumber;
        this.spotId=spotId;
        this.entryTime=entryTime;
    }

    public String getTicketId(){
        return ticketId;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public String getSpotId(){
        return spotId;
    }
    public LocalDateTime getEntryTime(){
        return entryTime;
    }
}
