package org.example.ParkingLotStrategy;

import lombok.Builder;
import lombok.Data;
import org.example.ParkingLot.models.VehicleType;

@Data
@Builder
public class Vehicle {
    String vehcileId;
    VehicleType vehicleType;
}
