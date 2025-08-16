package org.example.BookMyShowNew;

import java.util.ArrayList;
import java.util.List;

public class BookMyShowNew {

    public static void main(String[] args) {
        BookMyShowSercvice bookMyShowSercvice = new BookMyShowSercvice();
        TheaterNew theaterNew = new TheaterNew();


        MoviesNew moviesNew1 = new MoviesNew("Movie1");
        theaterNew.addMovie(moviesNew1);
        ScreenNew screenNew = new ScreenNew(10 , 1 , "10am");
        ShowNew showNew1 = new ShowNew(screenNew);

        moviesNew1.addShow(showNew1);

        bookMyShowSercvice.addTheater(theaterNew);
        BookingTicket bookingTicket  = bookMyShowSercvice.bookMovieTicket("Movie1" , "10am" , 2 , "name");


        System.out.println("bookingTicket " + bookingTicket);



    }
}
