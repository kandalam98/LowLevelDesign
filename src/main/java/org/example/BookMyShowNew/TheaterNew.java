package org.example.BookMyShowNew;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TheaterNew {
    List<MoviesNew> moviesNewList = new ArrayList<>();

    public void addMovie(MoviesNew moviesNew){
        moviesNewList.add(moviesNew);
    }
    public void removeMovie(MoviesNew moviesNew){
        moviesNewList.remove(moviesNew);
    }
}
