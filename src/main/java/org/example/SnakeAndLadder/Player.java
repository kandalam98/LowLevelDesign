package org.example.SnakeAndLadder;

public class Player {
    private int id;
    private String playerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Player(int id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }
}
