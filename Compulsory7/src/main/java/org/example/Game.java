package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // variabila pentru bag
    private final Bag bag = new Bag(4);
    // variabila pentru lista de jucatori
    private final List<Player> players = new ArrayList<>();
    // indexul player ului curent
    private int currentPlayer = 0;
    // obj pentru sincronizare
    private final Object turnLock = new Object();
    // add player

    public void addPlayer(Player player) {
        player.setGame(this);
        players.add(player);
    }
    // metoda pentru desfasurares jocului
    public void play() {
        // initializeaza pentru fiecare jucator un array gol de tiles
        for (Player player : players) {
            player.setTiles(new ArrayList<>());
        }
        // cat timp exista tiles, fiecare jucator "isi face randul"
        while (!bag.getTiles().isEmpty()) {
            synchronized (turnLock) {
                Player current = players.get(currentPlayer);
                current.run();
                currentPlayer = (currentPlayer + 1) % players.size();
            }
        }
        // afisare jucatori si listele lor
        for (Player player : players) {
            System.out.println("Name: " + player.getName());
            System.out.println("Tiles:");
            for (Tile tile : player.getTiles()) {
                System.out.println(tile);
            }
            System.out.println();
        }
    }
    // getter pentru bag
    public Bag getBag() {
        return bag;
    }
    // getter pentru obiectul care efectueaza sincronizarea
    public Object getTurnLock() {
        return turnLock;
    }
    public static void main(String args[]) {
        // creare joc nou
        Game game = new Game();
        List<Tile> emptyTiles = new ArrayList<>();
        // adaugare jucatori
        game.addPlayer(new Player("Player 1", emptyTiles));
        game.addPlayer(new Player("Player 2", emptyTiles));
        game.addPlayer(new Player("Player 3", emptyTiles));
        game.play();
    }
}
