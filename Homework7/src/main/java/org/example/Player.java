package org.example;

import java.util.*;

import static java.lang.Thread.sleep;

public class Player {
    // variabila pentru numele jucatorului
    private String name;
    // variabila pentru game
    private Game game;
    // variabila pentru starea jocului
    private boolean running = true;
    // lista de tiles
    private List<Tile> tiles = new ArrayList<>();
    // variabila pentru scor
    private int score =0;
    // getter pentru scor
    public int getScore() {
        return score;
    }
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
                while (!game.getBag().getTiles().isEmpty() && game.getCurrentPlayer() != this) {
                    try {
                        game.getTurnLock().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // daca bag nu este gol, jucatorul curent extrage cate 1 tile care se adauga listei corespunzatoare jucatorului respectiv
                if (!game.getBag().getTiles().isEmpty()) {
                    List<Tile> extractedTiles = game.getBag().extractTiles(1);
                        System.out.println(this.name + ": extracted " + extractedTiles);
                        this.tiles.addAll(extractedTiles);
                        // se calculeaza cea mai lunga secventa
                        int sequenceValue = calculateSequenceValue(this.tiles);
                        if (sequenceValue > score) {
                            score = sequenceValue;
                        }
                        // se calculeaza daca exista secventa inchisa, si daca are se termina jocul, altfel continua jucatorul urmator
                        if (hasClosedSequence(this.tiles)) {
                            game.endGame(this);
                        } else {
                            game.nextPlayer();
                        }
                }

            }
            // pauza de 1 sec intre runde
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;
        }
    }
    // metoda ce verifica daca exista secventa inchisa pentru a incheia jocul
    private boolean hasClosedSequence(List<Tile> tiles) {
        // daca nu exista cel putin un numar de tokens => nu exista secventa
        if (tiles.size() < game.getCapacity()) {
            return false;
        }
        // lista e sortata dupa primul numar din tuplu si apoi facem alta lista doar cu valorile unice
        tiles.sort(Comparator.comparingInt(Tile::getFirst));
        Set<Tile> seen = new HashSet<>();
        List<Tile> uniqueTuples = new ArrayList<>();
        for (Tile pair : tiles) {
            if (!seen.contains(pair)) {
                uniqueTuples.add(pair);
                seen.add(pair);
            }
        }
        // se itereaza prin lista cu valori unice si se verifica secventa
        for (int i = 0; i < uniqueTuples.size() - 1; i++) {
            Tile currentPair = uniqueTuples.get(i);
            Tile nextPair = uniqueTuples.get(i + 1);
            if (currentPair.getSecond() != nextPair.getFirst()) {
                return false;
            }
        }

        // verifica daca ultimul element al ultimei perechi este egal cu primul element al primei perechi
        Tile firstPair = uniqueTuples.get(0);
        Tile lastPair = uniqueTuples.get(uniqueTuples.size() - 1);
        return lastPair.getSecond() == firstPair.getFirst();

    }
    // calculeaza valorea uncei secvente
    public static int calculateSequenceValue(List<Tile> tiles) {
        int sequence = 1;
        // verifica daca primul element incepe cu 0 (valoarea unitiala a secventei)
        if (tiles.get(0).getFirst() != 0) {
            return 0;
        }

        // lista e sortata dupa primul numar din tuplu si apoi facem alta lista doar cu valorile unice
        tiles.sort(Comparator.comparingInt(Tile::getFirst));
        Set<Tile> seen = new HashSet<>();
        List<Tile> uniqueTuples = new ArrayList<>();
        for (Tile pair : tiles) {
            if (!seen.contains(pair)) {
                uniqueTuples.add(pair);
                seen.add(pair);
            }
        }
        // se itereaza prin lista cu valori unice si se calculeaza numarul secventei
        for (int i = 0; i < uniqueTuples.size() - 1; i++) {
            Tile currentPair = uniqueTuples.get(i);
            Tile nextPair = uniqueTuples.get(i + 1);
            if (currentPair.getSecond() != nextPair.getFirst()) {
                break;
            }
            sequence += 1;
        }
        return sequence;
    }

}
