package org.example.SnakeAndLadder;

import java.util.*;

public class PlaySnakeAndLadder {
    public static void main(String[] args) {
        Dice dice = new Dice(1);
        Player p1 = new Player(1,"Alberts");
        Player p2 = new Player(2,"Pintoss");
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        Jump snake1 = new Jump(10,2);
        Jump snake2 = new Jump(99,12);
        List<Jump> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        Jump ladder1 = new Jump(5,25);
        Jump ladder2 = new Jump(40,89);
        List<Jump> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        Map<Integer,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put(1,0);
        playersCurrentPosition.put(2,0);
        GameBoard gb=new GameBoard(dice,snakes,ladders,allPlayers,playersCurrentPosition,100);
        gb.startGame();
    }
}
