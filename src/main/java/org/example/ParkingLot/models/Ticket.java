package org.example.ParkingLot.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {
    String ticketNumber;
    Vehicle vehicle;
    long startTime;
    long endTime;
    ParkingSlot parkingSlot;
    public static Ticket createTicket(Vehicle vehicle,ParkingSlot parkingSlot){
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle)
                .ticketNumber(vehicle.getVehicleId()+System.currentTimeMillis())
                .build();
    }
}
