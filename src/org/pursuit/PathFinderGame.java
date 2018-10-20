package org.pursuit;

import java.util.Scanner;

public class PathFinderGame implements Game{

    Scanner scanner = new Scanner(System.in);
    int tile;

    public void startGame() {
        logo();
        instructions();
        input();
        System.out.println("Tile: " + tile);
        checkValue(roll());
    }

    private void logo() {
        System.out.println("Logo");
    }

    private void instructions() {
        System.out.println("Instructions");
    }

    private void input() {
        scanner.nextLine();
        int roll = roll();
    }

    private int roll() {
        int random = (int) Math.ceil(Math.random() * 10);
        System.out.println("You rolled: " + random);
        return random;
    }

    private void checkValue(int roll) {
        //System.out.println("You rolled: " + roll);
        while (tile <= 100) {
            input();
            if (roll == 7) {
                System.out.println("You hit 7!");
                tile = tile + roll + roll();
                System.out.println("Your tiles are " + tile);
            } else if (roll == 10) {
                System.out.println("You hit 10!");
                int newRandom = roll();
                if (tile <= 10 && newRandom >= tile) {
                    System.out.println("Landed on 10, but newRandom is greater or equal to tile");
                    tile = 1;
                } else {
                    tile = tile - newRandom;
                }
                System.out.println("Your tiles are" + tile);
            } else {
                System.out.println( "Nothing special, changing tile from " + tile + " to " + (tile + roll));
                tile = tile + roll;
                System.out.println("New value " + tile);
            }
        }
    }
}

@Override
public void startGame() {

}