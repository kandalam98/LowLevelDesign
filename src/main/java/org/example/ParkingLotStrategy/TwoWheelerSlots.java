package org.example.ParkingLotStrategy;

import org.example.ParkingLot.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerSlots implements ParkingSlotAbs {

    List<ParkingSlotStrat> parkingSlotStratList;

    public List<ParkingSlotStrat> getParkingSlotStratList() {
        return parkingSlotStratList;
    }


    TwoWheelerSlots(int size){
        parkingSlotStratList = new ArrayList<>(size);
        for(int i=0 ; i< size ;i++){
            parkingSlotStratList.add(new ParkingSlotStrat());
        }
    }
    @Override
    public Integer parkingFee(Integer duration) {
        return duration;
    }

    @Override
    public TicketStrategy assignSlot(Vehicle vehicle  ) {
        for(ParkingSlotStrat slot : parkingSlotStratList){
            if( slot.getIsFree() == Boolean.TRUE) {
                slot.setIsFree(Boolean.FALSE);
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
