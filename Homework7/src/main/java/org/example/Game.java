package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    // variabila pentru numarul unei secvente (adica n)
    private int capacity;
    // variabila pentru bag initializata cu capacitatea
    private Bag bag = new Bag(capacity);
    // variabila pentru lista de jucatori
    private final List<Player> players = new ArrayList<>();
    // indexul player ului curent
    private int currentPlayer = 0;
    // obj pentru sincronizare
    private final Object turnLock = new Object();
    // variabila pentru a verifica sfarsitul jocului
    private boolean gameEnded = false;
    // getter pentru capacitate
    public int getCapacity() {
        return capacity;
    }
    // cosntructor
    public Game(int capacity) {
        this.capacity = capacity;
        this.bag = new Bag(capacity);
    }
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
        while (!bag.getTiles().isEmpty() && !gameEnded) {
            players.get(currentPlayer).run();
        }
        // daca jocul nu s-a terminat, dar bag e goala
        if (!gameEnded) {
            endGame(null);
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
    // getter pentru jucatorul curent
    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }
    // metoda pentru trecerea la urmatorul jucator
    public void nextPlayer() {
        synchronized (turnLock) {
            currentPlayer = (currentPlayer + 1) % players.size();
            turnLock.notifyAll();
        }
    }
    // metoda pentru terminarea jocului
    public void endGame(Player winner) {
        gameEnded = true;
            // daca nu exista castigator, calculam lungimea fiecuruia si o luam pe cea mai mare
            if (winner == null) {
                Player playerWithLongestSequence = null;
                int maxSequenceLength = 0;
                for (Player player : players) {
                    int sequenceLength = player.calculateSequenceValue(player.getTiles());
                    if (sequenceLength > maxSequenceLength) {
                        maxSequenceLength = sequenceLength;
                        playerWithLongestSequence = player;
                    }
                }
                // daca nu exista jucator care sa formeze o secventa, afisam acest lucru
                if (playerWithLongestSequence == null) {
                    System.out.println("The game is over, but no player has formed a sequence.");
                } else {
                    // altfel, afisam jucatorul si cat valoreaza secventa sa
                    System.out.println("The game is over. " + playerWithLongestSequence.getName() + " has the largest sequence: " + maxSequenceLength + ".");
                }
            } else {
                // Dacă exista un caștigator, il afisam
                System.out.println("The game is finished. The winner is " + winner.getName() + " with " + winner.calculateSequenceValue(winner.getTiles()) + " points.");
            }
        }



    public static void main(String args[]) {
        // creare joc nou
        Game game = new Game(5);
        List<Tile> emptyTiles = new ArrayList<>();
        // adaugare jucatori
        game.addPlayer(new Player("Player 1", emptyTiles));
        game.addPlayer(new Player("Player 2", emptyTiles));
        game.addPlayer(new Player("Player 3", emptyTiles));
        // creare deamon care monitorizeza timpul
        Daemon deamon = new Daemon(game);
        Thread timer = new Thread(deamon);
        timer.setDaemon(true);
        timer.start();
        game.play();
    }
}
