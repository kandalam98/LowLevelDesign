package org.example.ElevatorDesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorController {
    List<Floor> floorList ;
    Queue<Passenger> upQueue;
    Elevator elevator;

    public ElevatorController(int size) {

        this.floorList = new ArrayList<>(size);
        this.upQueue = new LinkedList<>();
        this.elevator = new Elevator();
        for(int i=1 ; i<=size; i++) {
            floorList.add(new Floor(i));
        }
    }
    public void requestElevator(int sourceFloor,int destinationFloor){
        Floor source = floorList.get(sourceFloor-1);
        Floor destination = floorList.get(destinationFloor-1);
        Passenger passenger = new Passenger(destinationFloor);
        upQueue.offer(passenger);
        if(elevator.getDirection() == Direction.NONE){
            if(sourceFloor > elevator.getCurrentFloor()) {
                elevator.setDirection(Direction.UP);
            } else {
                elevator.setDirection(Direction.DOWN);
            }
        }
    }
    public void processRequest(){
        while(!upQueue.isEmpty()){
            Passenger passenger = upQueue.poll();
            int destinationFloor = passenger.getDestinationFloor();
            if(destinationFloor > elevator.getCurrentFloor()){
                elevator.moveToFloor(destinationFloor);
            } else if(destinationFloor < elevator.getCurrentFloor()){
                elevator.moveToFloor(destinationFloor);
            }

//            if(elevator.getDirection() == Direction.UP){
//                if(destinationFloor > elevator.getCurrentFloor()){
//                    elevator.moveToFloor(destinationFloor);
//                } else {
//                    elevator.setDirection(Direction.DOWN);
//                    elevator.moveToFloor(destinationFloor);
//                }
//            } else {
//                if(destinationFloor < elevator.getCurrentFloor()){
//                    elevator.moveToFloor(destinationFloor);
//                } else {
//                    elevator.setDirection(Direction.UP);
//                    elevator.moveToFloor(destinationFloor);
//                }
//            }
        }
    }

    public static void main(String[] args){
        ElevatorController elevatorController = new ElevatorController(5);
        elevatorController.requestElevator(1,3);
        elevatorController.requestElevator(2,5);
        elevatorController.requestElevator(5,1);
        elevatorController.processRequest();
    }
}
