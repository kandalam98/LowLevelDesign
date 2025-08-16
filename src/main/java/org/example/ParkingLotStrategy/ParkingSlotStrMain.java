package org.example.ParkingLotStrategy;

import org.example.ParkingLot.models.VehicleType;

public class ParkingSlotStrMain {

    public static void main(String[] args) throws InterruptedException  {

        TwoWheelerSlots twoWheelerSlots = new TwoWheelerSlots(1);
        FourWheelerSlots fourWheelerSlots = new FourWheelerSlots(1);

        ParkingSlotList parkingSlotList = new ParkingSlotList(fourWheelerSlots , twoWheelerSlots);

        Vehicle vehicle1 = Vehicle.builder().vehicleType(VehicleType.TWOWHEELER)
                .vehcileId("1").build();
        Vehicle vehicle2 = Vehicle.builder().vehicleType(VehicleType.FOURWHEELER)
                .vehcileId("2").build();

        Vehicle vehicle3 = Vehicle.builder().vehicleType(VehicleType.TWOWHEELER)
                .vehcileId("3").build();
        Vehicle vehicle4 = Vehicle.builder().vehicleType(VehicleType.FOURWHEELER)
                .vehcileId("4").build();


        TicketStrategy ticketStrategy = parkingSlotList.assignTicket(vehicle1);
        TicketStrategy ticketStrategy2 = parkingSlotList.assignTicket(vehicle2);
        System.out.print("TicketNumber " + ticketStrategy);
        System.out.print("TicketNumber " + ticketStrategy2);
        System.out.print("TicketNumber " + parkingSlotList.assignTicket(vehicle3));
        Thread.sleep(10000);
        Integer price1 = parkingSlotList.getPrice(ticketStrategy);

        Integer price2 =  parkingSlotList.getPrice(ticketStrategy2);

        System.out.print("price1 " + price1);

        System.out.print("price2 " + price2);



    }
}
