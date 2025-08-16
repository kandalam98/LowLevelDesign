package org.example.BookMyShowNew;

import lombok.Data;
import org.example.BookMyShow.Seat;

import java.util.List;
@Data
public class BookingTicket {
    int bookingId;
    String payment;

    ShowNew showNew;
    List<Seat> seatList;

    @Override
    public String toString() {
        return "BookingTicket{" +
                "bookingId=" + bookingId +
                ", payment='" + payment + '\'' +
                ", showNew=" + showNew +
                ", seatList=" + seatList +
                '}';
    }

    public BookingTicket(int bookingId, String payment, ShowNew showNew, List<Seat> seatList) {
        this.bookingId = bookingId;
        this.payment = payment;
        this.showNew = showNew;
        this.seatList = seatList;
    }
}
