package org.example.BookMyShowNew;

import org.example.BookMyShow.Seat;

import java.util.ArrayList;
import java.util.List;

public class BookMyShowSercvice {


    Integer counter = 1;
    List<TheaterNew> theaterNews = new ArrayList<>();
    public void addTheater(TheaterNew theaterNew){
        theaterNews.add(theaterNew);
    }

    public BookingTicket bookMovieTicket(String movieName , String showTime , Integer totalTickets , String bookName ){
        for( TheaterNew theaterNew : theaterNews ){
            for(MoviesNew  moviesNew : theaterNew.getMoviesNewList()) {
                if(moviesNew.getMovieName().equalsIgnoreCase(movieName) ) {
                    return  checkShowAndSeats(moviesNew , showTime , totalTickets , bookName);
                }
            }
        }
        return null;
    }

    private BookingTicket checkShowAndSeats(MoviesNew moviesNew , String showTime , Integer totalTickets , String bookName ) {
        for(ShowNew show : moviesNew.getShowNewList() ) {
            if( show.getScreenNew().getShowStartTime().equalsIgnoreCase(showTime)) {
                if( show.getAvailableSeats() > totalTickets  ) {
                    List<Seat> seats = show.bookTicket(totalTickets , bookName);
                    BookingTicket bookingTicket = new BookingTicket(counter , null , show , seats );
                    return bookingTicket;
                }
            }
        }
        return null;
    }

}
