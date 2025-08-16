package org.example.ParkingLotStrategy;

import lombok.Builder;
import lombok.Data;
import org.example.ParkingLot.models.Ticket;

@Data
@Builder
public class TicketStrategy {
    String ticketNumber;
    Vehicle vehicle;
    long startTime;
    long endTime;
    ParkingSlotStrat parkingSlotStrat;
    public static TicketStrategy createTicket(Vehicle vehicle, ParkingSlotStrat parkingSlotStrat){
        return TicketStrategy.builder()
                .parkingSlotStrat(parkingSlotStrat)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle)
                .ticketNumber(vehicle.getVehcileId()+System.currentTimeMillis())
                .build();
    }
}
