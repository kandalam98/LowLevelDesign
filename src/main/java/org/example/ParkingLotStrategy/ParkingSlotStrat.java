package org.example.ParkingLotStrategy;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingSlotStrat {
    String id;
    Vehicle vehicle;
    Boolean isFree = Boolean.TRUE;
}
