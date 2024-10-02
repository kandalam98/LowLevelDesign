package org.example.BookMyShow;

import java.util.List;

public class Booking {

    int bookingId;
    Show show;

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", show=" + show +
                ", bookedSeats=" + bookedSeats +
                ", payment='" + payment + '\'' +
                '}';
    }

    List<Seat> bookedSeats;

    public Booking(int bookingId, Show show, List<Seat> bookedSeats, String payment) {
        this.bookingId = bookingId;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    String payment;
}
