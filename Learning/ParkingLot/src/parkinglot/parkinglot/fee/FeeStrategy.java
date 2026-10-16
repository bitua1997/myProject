package parkinglot.fee;

import java.time.LocalDateTime;

import parkinglot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket,
                        LocalDateTime exitTime);
}
