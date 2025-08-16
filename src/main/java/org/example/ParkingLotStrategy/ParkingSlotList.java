package org.example.ParkingLotStrategy;

import org.example.ParkingLot.models.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSlotList {
    List<ParkingSlotAbs> fourWheelerSlotsList ;
    List<ParkingSlotAbs> twoWheelerSlotsList;

    Map< VehicleType,TwoWheelerSlots  > twowheelerListMap ;
    Map< VehicleType, FourWheelerSlots > fourWheelerListMap ;

    Map< VehicleType, ParkingSlotAbs > commanMap = new HashMap<>();

    FourWheelerSlots fourWheelerSlots;
    TwoWheelerSlots twoWheelerSlots;

    ParkingSlotList(FourWheelerSlots fourWheelerSlots , TwoWheelerSlots twoWheelerSlots) {
        this.fourWheelerSlots = fourWheelerSlots;
        this.twoWheelerSlots = twoWheelerSlots;
        commanMap.put(VehicleType.TWOWHEELER , twoWheelerSlots );
        commanMap.put(VehicleType.FOURWHEELER , fourWheelerSlots );

    }

    TicketStrategy assignTicket(Vehicle vehicle){
        ParkingSlotAbs parkingSlotAbs = commanMap.get(vehicle.vehicleType);
        if( parkingSlotAbs != null ) {
            return parkingSlotAbs.assignSlot(vehicle);
        }
//        if( vehicle.getVehicleType().equals(VehicleType.TWOWHEELER)) {
//            return twowheelerListMap.get(VehicleType.TWOWHEELER).assignSlot(vehicle);
//        } else if( vehicle.getVehicleType().equals(VehicleType.FOURWHEELER)) {
//            return fourWheelerListMap.get(VehicleType.FOURWHEELER).assignSlot(vehicle);
//        }
        return null;
    }
    public Integer getPrice(TicketStrategy ticketStrategy){
        long endTime = System.currentTimeMillis();
        ParkingSlotAbs parkingSlotAbs = commanMap.get(ticketStrategy.getVehicle().vehicleType);
        if( parkingSlotAbs != null ) {
            Integer duration = (int) (endTime-ticketStrategy.getStartTime())/1000;
            parkingSlotAbs.makeSlotFree(ticketStrategy.getParkingSlotStrat());
            return parkingSlotAbs.parkingFee(duration);
        }
        return null;
    }
}
