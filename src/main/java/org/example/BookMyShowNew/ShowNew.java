package org.example.BookMyShowNew;


import lombok.Data;
import org.example.BookMyShow.Seat;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShowNew {
    ScreenNew screenNew;

    Integer availableSeats;

    ShowNew(ScreenNew screenNew ){
        this.screenNew = screenNew;
        this.availableSeats = screenNew.getTotalSeats();
    }
    public Integer totalSeats() {
        return screenNew.getTotalSeats();
    }
    public Integer availableSeats() {
        int counter = 0;
        for(Seat seat : screenNew.getSeatList()) {
            if(!seat.isBooked()){
                counter++;
            }
        }
        return availableSeats = counter;
    }
    public List<Seat> bookTicket(Integer no , String bookingName) {
        List<Seat>  bookedSeats = new ArrayList<>();
        for(Seat seat : screenNew.getSeatList()) {
            seat.setBooked(true);
            seat.setBooking(bookingName);
            bookedSeats.add(seat);
        }
        return bookedSeats;
    }


}
