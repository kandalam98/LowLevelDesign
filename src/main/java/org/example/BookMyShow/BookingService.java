package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    List<Theater> theaterList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();

    int counterBookingId=0;

    void addTheater(Theater theater){
        theaterList.add(theater);
    }

    void searchMovieName(String movieName){
        for(Theater theater : theaterList){
            for(Show show : theater.showList){
                System.out.println("show " + show.getMovie().getMovieName());
                if(show.getMovie().getMovieName().equals(movieName)){
                    System.out.println("Movie Found in Theater "+ theater.getTheaterName() +" Location " + theater.getLocation());
                }
            }

        }
        System.out.println("Done");

    }
    void bookMovie(String movie, int tickets,String bookName){
        for(Theater theater : theaterList){
            for(Show show : theater.showList){
                if(show.getMovie().getMovieName().equals(movie)){

                    if(show.getAvailableSeats() >= tickets){

                        List<Seat> seats = show.getScreen().getSeatList();
                        List<Seat> bookedSeats = new ArrayList<>();

                        for(Seat seat : seats){

                            if(seat.isBooked() == false && tickets > 0){
                                seat.setBooking(bookName);
                                seat.setBooked(true);
                                bookedSeats.add(seat);
                                System.out.println("Seat in booking  "+seat);
                                tickets--;
                            }
                        }


                        show.setAvailableSeats(show.getAvailableSeats() - tickets);


                        Booking booking1 = new Booking(counterBookingId++,show,bookedSeats,"payment : "+counterBookingId);
                        System.out.println("Booking Done for movei " + booking1.toString());
                        bookingList.add(booking1);
                    }

                }
            }
        }
    }

    public Screen formSeats(Screen screen) {

        for(int i=1 ;i <= screen.getMaxSeatCount() ;i++){
            Seat seat1 = new Seat(i);
            screen.seatList.add(seat1);
        }
        return screen;
    }

    void showAvailableSeats(String movie){
        for(Theater theater : theaterList){
            for(Show show : theater.showList){
                if(show.getMovie().getMovieName().equalsIgnoreCase(movie)){
                    List<Seat> seat = show.getScreen().getSeatList();
                    System.out.println("seat size "+seat.size());
                    for(Seat set : seat){
                        System.out.println("seat  "+set);
                        if(set.getBooking() == null){
                            System.out.println("Seat is avaialable  : " + set.getSeatNumber());
                        }

                    }
                }
            }
        }
    }
}
