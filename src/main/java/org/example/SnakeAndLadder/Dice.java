package org.example.SnakeAndLadder;

public class Dice {
    int diceNumber;

    public Dice(int diceNumber) {
        this.diceNumber = diceNumber;
    }
    public int rollDice(){
        return ((int) (Math.random()*(6*diceNumber - 1*diceNumber))) + 1;
    }
}
