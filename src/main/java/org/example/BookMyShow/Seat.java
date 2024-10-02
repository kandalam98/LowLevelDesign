package org.example.BookMyShow;

public class Seat {

    int seatNumber;

    String bookingName;
    boolean isBooked= false;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBooking() {
        return bookingName;
    }

    public void setBooking(String bookingName) {
        this.bookingName = bookingName;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
