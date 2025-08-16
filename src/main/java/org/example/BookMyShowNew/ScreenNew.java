package org.example.BookMyShowNew;

import lombok.Data;
import org.example.BookMyShow.Seat;

import java.util.ArrayList;
import java.util.List;
@Data
public class ScreenNew {
    Integer screenNumber;

    String showStartTime;
    List<Seat> seatList;

    Integer totalSeats;

    ScreenNew(Integer seatSize , Integer screenNumber , String showStartTime) {
        seatList = new ArrayList<>(seatSize);
        for(int i=0 ; i<seatSize ;i++){
            Seat seat = new Seat(i);
            seatList.add(seat);
        }
        this.totalSeats = seatSize;
        this.screenNumber = screenNumber;

        this.showStartTime = showStartTime;
    }

}
