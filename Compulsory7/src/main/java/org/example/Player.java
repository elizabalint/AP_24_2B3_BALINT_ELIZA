package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    // variabila pentru numele jucatorului
    private String name;
    // variabila pentru game
    private Game game;
    // variabila pentru starea jocului
    private boolean running = true;
    // lista de tiles
    private List<Tile> tiles = new ArrayList<>();
    // constructor pentru numele si lista de tails
    public Player(String name, List<Tile> tiles) {
        this.name = name;
        this.tiles = tiles;
    }
    // getter pentru name
    public String getName() {
        return name;
    }
    // setter pentru name
    public void setName(String name) {
        this.name = name;
    }
    // getter pentru game
    public Game getGame() {
        return game;
    }
    // setter pentru game
    public void setGame(Game game) {
        this.game = game;
    }
    // verificarea starii jocului
    public boolean isRunning() {
        return running;
    }
    // setter pentru starea jocului
    public void setRunning(boolean running) {
        this.running = running;
    }
    // getter pentru lista de tails
    public List<Tile> getTiles() {
        return tiles;
    }
    // setter pentru lista de tails
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
    // metoda pentru a executa "randul" fiecarui jucator
    public void run() {
         while (running) {
             synchronized (game.getTurnLock()) {
                 if (!game.getBag().getTiles().isEmpty()) {
                    List<Tile> extractedTiles = game.getBag().extractTiles(1);
                    if (!extractedTiles.isEmpty()) {
                        this.tiles.addAll(extractedTiles);
                        break;
                    }
                }
            }
        }
    }
}