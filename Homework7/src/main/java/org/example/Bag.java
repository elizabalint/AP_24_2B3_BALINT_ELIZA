package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bag {
    //lista de tiles
    private final List<Tile> tiles = new ArrayList<>();
    // constructor default
    public Bag() {
    }
    // constructor ce genereaza tupluri de tiles random
    public Bag(int n){
        for(int i=1;i<=n*n;i++) {
            Random random = new Random();
            int j = random.nextInt(n);
            int k;
            if (j == n-1)
                 k = 0;
            else
                k = j+1;
            tiles.add(new Tile(j,k));
        }
        Collections.shuffle(tiles);
    }
    // extragerea unui numar de tiles din lista
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {

                break;
            }
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }

    // getter pentru lista de tiles
    public List<Tile> getTiles() {
        return tiles;
    }
}