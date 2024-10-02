package org.example.ElevatorDesign;

import org.example.LoggerImpl.Logger;

public class Elevator {

    Logger logger = new Logger();
    int currentFloor;
    private Direction direction;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Elevator() {
        this.currentFloor = -1;
        this.direction = direction.NONE;
    }
    public void moveToFloor(int floor) {
        logger.info("Elevator moving " + direction + " from floor: " + currentFloor + " to floor: " + floor);
        this.currentFloor = floor;
    }
}
