package org.example;
import lombok.*;

import java.util.LinkedList;

public class Destination {
    //variabila pentru numele destinatiei
    protected String name;
    // constructor
    public Destination(String name) {
        this.name = name;
    }
    // getter pentru nume
    public String getName() {
        return name;
    }
    // setter pentru nume
    public void setName(String name) {
        this.name = name;
    }
    // toString pentru afisarea informatiilor despre destinatie
    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
