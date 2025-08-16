package org.example.ParkingLotStrategy;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerSlots implements   ParkingSlotAbs {
    List<ParkingSlotStrat> parkingSlotStratList ;

    public List<ParkingSlotStrat> getParkingSlotStratList() {
        return parkingSlotStratList;
    }

    FourWheelerSlots(int size ) {
        parkingSlotStratList = new ArrayList<>(size);
        for(int i=0 ; i< size ;i++){
            parkingSlotStratList.add(new ParkingSlotStrat());
        }
    }
    @Override
    public Integer parkingFee(Integer duration) {
        return duration * 2;
    }
    @Override
    public TicketStrategy assignSlot(Vehicle vehicle ) {
        for(ParkingSlotStrat slot : parkingSlotStratList){
            if( slot.getIsFree() == Boolean.TRUE) {
                return TicketStrategy.createTicket(vehicle , slot);
            }
        }
        return null;
    }
    @Override
    public void makeSlotFree(ParkingSlotStrat parkingSlotStrat){
        parkingSlotStrat.setIsFree(Boolean.TRUE);
        parkingSlotStrat.setVehicle(null);
        parkingSlotStrat.setId(null);

    }
}
