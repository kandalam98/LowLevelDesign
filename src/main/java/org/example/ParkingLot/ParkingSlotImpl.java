package org.example.ParkingLot;

import org.example.ParkingLot.models.*;

import java.util.List;
import java.util.Map;

public class ParkingSlotImpl {
    List<ParkingFloor> parkingFloorList;
    Address address;

    public ParkingSlotImpl(List<ParkingFloor> parkingFloorList, Address address, String nameOfParking) {
        this.parkingFloorList = parkingFloorList;
        this.address = address;
        this.nameOfParking = nameOfParking;
    }

    String nameOfParking;
    private static ParkingSlotImpl parkingLotImpl=null;

    static ParkingSlotImpl  getInstance(List<ParkingFloor> parkingFloorList, Address address, String nameOfParking){
        if(parkingLotImpl == null ){
            parkingLotImpl = new ParkingSlotImpl(parkingFloorList,address,nameOfParking);
        }
        return parkingLotImpl;
    }

    public void addFloors(String name ,Map<ParkingLotType, Map<String, ParkingSlot>> parkingLotTypeMapMap ){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkingLotTypeMapMap);
        parkingFloorList.add(parkingFloor);
    }
    public void removeFloor(ParkingFloor parkingFloor){
        parkingFloorList.remove(parkingFloor);
    }
    public Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot = checkIfSlotAvailable(vehicle);
        if(parkingSlot == null )return null;
        return  createAndAssignTicket(vehicle,parkingSlot);
    }
    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int) (endTime-ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingLotType().getPriceForParking(duration);
        return price;
    }

    private Ticket createAndAssignTicket(Vehicle vehicle,ParkingSlot parkingSlot) {
        return Ticket.createTicket(vehicle,parkingSlot);
    }

    private ParkingSlot checkIfSlotAvailable(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        for(ParkingFloor floor : parkingFloorList){
            parkingSlot = floor.checkSlotAvailable(vehicle);
            if(parkingSlot != null ){
                break;
            }
        }
        return parkingSlot;
    }


}
