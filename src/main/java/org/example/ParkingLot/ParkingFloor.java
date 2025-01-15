package org.example.ParkingLot;

import org.example.ParkingLot.models.ParkingLotType;
import org.example.ParkingLot.models.ParkingSlot;
import org.example.ParkingLot.models.Vehicle;
import org.example.ParkingLot.models.VehicleType;


import java.util.List;
import java.util.Map;

public class ParkingFloor {
    String floorName;

    public ParkingFloor(String floorName, Map<ParkingLotType, Map<String, ParkingSlot>> parkingLotTypeMapMap) {
        this.floorName = floorName;
        this.parkingLotTypeMapMap = parkingLotTypeMapMap;
    }

    Map<ParkingLotType, Map<String, ParkingSlot>> parkingLotTypeMapMap;

    public ParkingSlot checkSlotAvailable(Vehicle vehicle){
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingLotType parkingLotType = pickCorrectSlot(vehicleType);
        ParkingSlot parkingSlot = null;
        Map<String, ParkingSlot> parkingLotTypeMap = parkingLotTypeMapMap.get(parkingLotType);
        for(Map.Entry<String, ParkingSlot> parkingSlotMap : parkingLotTypeMap.entrySet() ){
            if(parkingSlotMap.getValue().isAvailable()){
                parkingSlot = parkingSlotMap.getValue();
                parkingSlot.addVehicle(vehicle);
            }
        }
        return parkingSlot;
    }
    private ParkingLotType pickCorrectSlot(VehicleType vehicleCategory) {
        if(vehicleCategory.equals(VehicleType.TWOWHEELER)) return ParkingLotType.TWOWHEELER;
        else if(vehicleCategory.equals(VehicleType.FOURWHEELER)) return ParkingLotType.FOURWHEELER;
        return null;
    }
}
