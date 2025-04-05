import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        System.out.println("***********************");
        System.out.println("Welcome to Hangman Game");
        System.out.println("***********************\n");
        while (true){
            System.out.println("1.Easy\n" + "2.Medium\n" + "3.Hard");
            System.out.println("Choose a difficulty by entering the representing number:");
            Scanner input = new Scanner(System.in);
            int difficulty = input.nextInt();
            if (difficulty == 1) {
                Easy easy = new Easy();
                easy.startGame();
                break;
            } else if (difficulty == 2) {
                Medium medium = new Medium();
                medium.startGame();
                break;
            } else if (difficulty == 3) {
                Hard hard = new Hard();
                hard.startGame();
                break;
            } else {
                System.out.println("Please enter a valid number\n");
            }
        }
    }
}
