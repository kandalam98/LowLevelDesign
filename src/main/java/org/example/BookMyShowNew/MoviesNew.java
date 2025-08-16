package org.example.BookMyShowNew;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoviesNew {

    String movieName;
    String duration;
    public MoviesNew(String movieName) {
        this.movieName = movieName;
    }

    List<ShowNew> showNewList = new ArrayList<>();

    public void addShow(ShowNew showNew){
        showNewList.add(showNew);
    }

    public void removeShow(ShowNew showNew){
        showNewList.remove(showNew);
    }
}
