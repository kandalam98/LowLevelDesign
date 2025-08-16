package org.example.ParkingLotStrategy;

public  interface ParkingSlotAbs {
    Integer parkingFee(Integer duration);
    TicketStrategy assignSlot(Vehicle vehicle);
    void makeSlotFree(ParkingSlotStrat vehicle);
}
