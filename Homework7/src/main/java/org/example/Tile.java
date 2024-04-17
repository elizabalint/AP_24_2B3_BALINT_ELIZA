package org.example;

import java.util.Objects;

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
    // getter pentru prima valoare
    public int getFirst() {
        return first;
    }
    // getter pentru a 2-a valoare
    public int getSecond() {
        return second;
    }
    // metoda equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile tile)) return false;
        return getFirst() == tile.getFirst() && getSecond() == tile.getSecond();
    }
    // metoda hascode
    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
    // metoda toString pentru afisare
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
