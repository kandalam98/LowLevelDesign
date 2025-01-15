package org.example.ParkingLot;

import org.example.ParkingLot.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotMain {
    public static void main(String[] args) throws InterruptedException {
        String nameOfParkingLot ="Pintosss Parking Lot";
        Address address = Address.builder().city("Bangalore").address("India").build();
        Map<ParkingLotType, Map<String, ParkingSlot>>  allSlots = new HashMap<>();
        Map<String,ParkingSlot> compactSlot = new HashMap<>();
        compactSlot.put("C1",new ParkingSlot("C1",ParkingLotType.TWOWHEELER));
        compactSlot.put("C2",new ParkingSlot("C2",ParkingLotType.TWOWHEELER));
        compactSlot.put("C3",new ParkingSlot("C3",ParkingLotType.TWOWHEELER));
        allSlots.put(ParkingLotType.TWOWHEELER,compactSlot);

        Map<String,ParkingSlot> largeSlot = new HashMap<>();
        largeSlot.put("L1",new ParkingSlot("L1",ParkingLotType.FOURWHEELER));
        largeSlot.put("L2",new ParkingSlot("L2",ParkingLotType.FOURWHEELER));
        largeSlot.put("L3",new ParkingSlot("L3",ParkingLotType.FOURWHEELER));
        allSlots.put(ParkingLotType.FOURWHEELER,largeSlot);

        ParkingFloor parkingFloor = new ParkingFloor("1",allSlots);
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(parkingFloor);
        ParkingSlotImpl parkingLot = ParkingSlotImpl.getInstance(parkingFloors,address,nameOfParkingLot);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.TWOWHEELER);
        vehicle.setVehicleId("KA-01-MA-9999");

        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println(" ticket number >> "+ticket.getTicketNumber());
        //persist the ticket to db here
        Thread.sleep(10000);
        double price = parkingLot.scanAndPay(ticket);
        System.out.println("price is >>" + price);
    }
}
