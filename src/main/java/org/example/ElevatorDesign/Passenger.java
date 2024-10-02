package org.example.ElevatorDesign;

public class Passenger {

    public Passenger(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    private int destinationFloor;

}
