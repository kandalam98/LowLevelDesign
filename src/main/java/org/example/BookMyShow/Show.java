package org.example.BookMyShow;

import java.util.List;

public class Show {
    //Show --> Movie , time , List<Integer> bookedSeats , Screen -- screenNumber , List<Seats>
    Movie movie;
    Screen screen;

    String showStartTime;

    Integer availableSeats ;

    public Show(Movie movie, Screen screen, String showStartTime) {
        this.movie = movie;
        this.screen = screen;
        this.showStartTime = showStartTime;
        this.availableSeats = screen.getSeatList().size();
    }

    public Show(Screen screen) {
        this.screen = screen;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime;
    }


}
