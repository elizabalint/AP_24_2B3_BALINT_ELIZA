package org.example;

import java.util.Iterator;

public class Daemon implements Runnable {
    // variabila pentru game
    private Game game;
    // limita de timp
    int timeLimit = 500;

    // constructor
    public Daemon(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        // variabila pentru timpul scurs
        System.out.println("Time: " +timeLimit);

        while (timeLimit >0) {
            // pauza de 10 milisecunde
            try {
                Thread.sleep(10);
                // incrementarea timpului scurs
                timeLimit--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // daca a trecut timpul, se opreste jocul
        System.out.println("Time is up.");
        game.endGame(null);
    }
}
