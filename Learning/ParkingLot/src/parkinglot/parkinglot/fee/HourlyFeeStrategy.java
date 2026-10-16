package parkinglot.fee;

import java.time.Duration;
import java.time.LocalDateTime;

import parkinglot.Ticket;
import parkinglot.VehicleType;

public class HourlyFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(Ticket ticket, LocalDateTime exitTime) {
        Duration duration= Duration.between(ticket.getEntryTime(), exitTime);
        long minutes=duration.toMinutes();
        long hours=(minutes+59)/60; // Round up to the next hour
        VehicleType type = ticket.getVehicle().getvehicleType();
        switch (type) {
            case CAR:
                return hours * 20.0;
            case BIKE:
                return hours * 10.0;
            case TRUCK:
                return hours * 50.0;
            default:
                return 0;
        }

    }
}

