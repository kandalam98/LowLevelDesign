package org.example.ParkingLot.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    String address ;
    String city;
}
