package org.example;

public class Tile {
    // variabila pentru prima valoare
    private int first;
    // variabila pentru a 2-a valoare
    private int second;
    // constructor
    public Tile(int first, int second) {
        this.first = first;
        this.second = second;
    }
    // metoda toString pentru afisare
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
