package org.example.SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {
    Dice dice;
    List<Jump> snakes;
    List<Jump> ladders;
    Queue<Player> playerQueue;
    Map<Integer,Integer> playersCurrentPosition;

    int boardSize;

    public GameBoard(Dice dice, List<Jump> snakes, List<Jump> ladders, Queue<Player> playerQueue, Map<Integer, Integer> playersCurrentPosition, int boardSize) {
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerQueue = playerQueue;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }
    /**Uses State and Strategy Design Pattern*/
    void startGame(){
        while (playerQueue.size() > 1){
            Player player = playerQueue.poll();
            int currPosition = playersCurrentPosition.get(player.getId());
            int diceNum = dice.rollDice();
            int nextPosition = currPosition + diceNum;
            if(nextPosition > boardSize){
                playerQueue.offer(player);
            }
            else if( nextPosition == boardSize){
                System.out.print(player.getPlayerName() + " Player Won");
            } else {
                int[] nextIndex= new int[1];
                nextIndex[0] = nextPosition;
                snakes.stream().forEach(v -> {
                    if(v.startIndex == nextPosition){
                        nextIndex[0] = v.endIndex;
                    }
                });
                if(nextPosition != nextIndex[0]){
                    System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextIndex[0]);
                }
                ladders.stream().forEach(v -> {
                    if(v.startIndex == nextPosition){
                        nextIndex[0] = v.endIndex;
                    }
                });
                if(nextPosition != nextIndex[0]){
                    System.out.println(player.getPlayerName() + " Got ladder at: "+ nextIndex[0]);
                }
                if( nextIndex[0] == boardSize){
                    System.out.println(player.getPlayerName() + " WON THE GAMEEE: "+ nextIndex[0]);
                } else {
                    playersCurrentPosition.put(player.getId() , nextIndex[0]);
                    playerQueue.offer(player);
                }
            }
        }
    }
}
