package org.example.ParkingLot.models;

import lombok.Builder;
import lombok.Data;

@Data
public class ParkingSlot {
    String id;
    Vehicle vehicle;

    @Builder.Default
    boolean isAvailable = true;

    public ParkingSlot(String id, ParkingLotType parkingLotType) {
        this.id = id;
        this.parkingLotType = parkingLotType;
    }

    ParkingLotType parkingLotType;
    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable=false;
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.isAvailable=true;
    }

}
