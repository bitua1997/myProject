package parkinglot;

import parkinglot.fee.HourlyFeeStrategy;

public class ParkingLotDemo {
    public static void main (String[] args) throws InterruptedException {
       ParkingLot parkinglot = new ParkingLot(new HourlyFeeStrategy()); 
       ParkingFloor floor1 = new ParkingFloor(1);
       ParkingFloor floor2 = new ParkingFloor(2);
       ParkingFloor floor3 = new ParkingFloor(3);

       floor1.addParkingSpot(new ParkingSpot("A1",VehicleType.BIKE));
       floor1.addParkingSpot(new ParkingSpot("A2",VehicleType.CAR));
       floor1.addParkingSpot(new ParkingSpot("A3",VehicleType.TRUCK));
       
       floor2.addParkingSpot(new ParkingSpot("B1",VehicleType.BIKE));
       floor2.addParkingSpot(new ParkingSpot("B2",VehicleType.CAR));
       floor2.addParkingSpot(new ParkingSpot("B3",VehicleType.TRUCK));
       
       floor3.addParkingSpot(new ParkingSpot("C1", VehicleType.BIKE));
       floor3.addParkingSpot(new ParkingSpot("C2",VehicleType.CAR));
       floor3.addParkingSpot(new ParkingSpot("C3", VehicleType.TRUCK));
       
        parkinglot.addFloor(floor1);
        parkinglot.addFloor(floor2);
        parkinglot.addFloor(floor3);

        Vehicle car = new Vehicle("JH01BA0001", VehicleType.CAR);
        Vehicle bike = new Vehicle("JH01CR0002", VehicleType.BIKE);
        Vehicle truck = new Vehicle("JH01CR0003", VehicleType.TRUCK);

        Ticket carTicket =  parkinglot.parkVehicle(car);
        Ticket bikeTicket = parkinglot.parkVehicle(bike);
        Ticket truckTicket = parkinglot.parkVehicle(truck);  

                System.out.println("========== PARKING ==========");

        System.out.println("Car Ticket   : " + carTicket.getTicketId());
        System.out.println("Floor        : " + carTicket.getFloorNumber());
        System.out.println("Spot         : " + carTicket.getSpotId());

        System.out.println();

        System.out.println("Bike Ticket  : " + bikeTicket.getTicketId());
        System.out.println("Floor        : " + bikeTicket.getFloorNumber());
        System.out.println("Spot         : " + bikeTicket.getSpotId());

        System.out.println();

        System.out.println("Truck Ticket : " + truckTicket.getTicketId());
        System.out.println("Floor        : " + truckTicket.getFloorNumber());
        System.out.println("Spot         : " + truckTicket.getSpotId());
        
        Thread.sleep(5000);

        System.out.println("\n========== UNPARKING ==========");
        parkinglot.unparkVehicle(carTicket.getTicketId());
        parkinglot.unparkVehicle(bikeTicket.getTicketId());
        parkinglot.unparkVehicle(truckTicket.getTicketId());

    }
    

}
