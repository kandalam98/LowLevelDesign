package org.example.ParkingLot.models;

public enum ParkingLotType {
    TWOWHEELER{
        public double getPriceForParking(long duration){
            return duration*0.05;
        }
    } ,
    FOURWHEELER{
        public double getPriceForParking(long duration){
            return duration*0.1;
        }
    };
    public abstract double getPriceForParking(long duration);
}
