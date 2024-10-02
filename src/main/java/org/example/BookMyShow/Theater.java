package org.example.BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    String theaterName;
    String location;

    List<Screen> screenList;

    List<Show> showList = new ArrayList<>();

    public Theater(String theaterName, String location, List<Screen> screenList) {
        this.theaterName = theaterName;
        this.location = location;
        this.screenList = screenList;
        this.showList = new ArrayList<>();
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(Show show) {
        showList.add(show);
    }
}
