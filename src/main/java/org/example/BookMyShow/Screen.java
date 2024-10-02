package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    Integer screenNumber;

    Integer maxSeatCount = 10;

    public Integer getMaxSeatCount() {
        return maxSeatCount;
    }

    public void setMaxSeatCount(Integer maxSeatCount) {
        this.maxSeatCount = maxSeatCount;
    }

    List<Seat> seatList = new ArrayList<>();

    public Integer getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }



    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public Screen(Integer screenNumber) {
        this.screenNumber = screenNumber;
    }
}
