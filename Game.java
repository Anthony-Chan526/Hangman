import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
    private BufferedReader reader;

    public void play(String word, int attempt) {
        word = word.toUpperCase();
        Scanner sc = new Scanner(System.in);
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            display.append("_");
        }
        System.out.println("\nYour Word: " + display);
        System.out.println("Attempts Left: " + attempt);
        while (display.indexOf("_") != -1 && attempt > 0) {
            System.out.println("\nEnter a letter: ");
            char letter = sc.next().charAt(0);
            letter = Character.toUpperCase(letter);
            if (word.indexOf(letter) != -1) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        display.setCharAt(i, letter);
                    }
                }
                System.out.println("Correct!");
                System.out.println("Your Word: " + display);
                System.out.println("Attempts Left: " + attempt);
            } else {
                attempt--;
                System.out.println("Incorrect!");
                System.out.println("Your Word: " + display);
                System.out.println("Attempts Left: " + attempt);
            }
        }
        if (display.indexOf("_") == -1) {
            System.out.println("\nYou Win!");
        } else if (attempt == 0) {
            System.out.println("\nYou Lose!");
        }
    }

    public void readFile() {
        try {
            reader = new BufferedReader(new FileReader("words.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Errors occurs, unable to read file.");
        }
    }

    public String getLine() {
        try {
            return (reader != null) ? reader.readLine() : null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getWord(String level) {
        ArrayList<String> words = new ArrayList<>();
        String line, word;
        readFile();
        while ((line = getLine()) != null) {
            String[] wordAndLevel = line.split(" ");
            if (wordAndLevel[1].equalsIgnoreCase(level)) {
                words.add(wordAndLevel[0]);
            }
        }
        word = words.get((int) (Math.random() * words.size()));
        return word;
    }

    public abstract void startGame();
}
