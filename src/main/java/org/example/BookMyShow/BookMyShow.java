package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {

    public static void main(String[] args) {
        //User -- name , Payment , List<Booking>
        //Booking - Show show ,Payment , List<Seats> bookedSeats , booking name
        //Theater - name , location , list<Screen>
        //Show --> Movie , time , List<Integer> bookedSeats , Screen -- screenNumber , List<Seats>
        //Movie -- ?
        List<Screen> screenList = new ArrayList<>();
        BookingService bookingService = new BookingService();

        Screen screen1ForTheater1 = new Screen(1);
        screen1ForTheater1 = bookingService.formSeats(screen1ForTheater1);
        Screen screen2ForTheater1 = new Screen(2);

        screenList.add(screen1ForTheater1);
        screenList.add(screen2ForTheater1);

        Theater theater1 = new Theater("Theater1","Hyd",screenList);
        Movie movie = new Movie(1,"Athadu",100);

        Show show1 = new Show(movie,screen1ForTheater1,"1:30pm");


        theater1.setShowList(show1);


        bookingService.addTheater(theater1);

        bookingService.searchMovieName("Athadu");

        bookingService.bookMovie("Athadu",3,"Srikar");

        bookingService.showAvailableSeats("Athadu");

        bookingService.bookMovie("Athadu",3,"Srikar");
        bookingService.showAvailableSeats("Athadu");



    }

}
