package exercises;

import java.util.Scanner;

public class HighLow {

    static long numberOfGuesses = 0;
    static long hiddenNumber = -1;
    static String userInput;
    static Scanner scanner;
    static String validation;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        hiddenNumber = (int) ((Math.random() * 100) + 1);
        System.out.format("I'm thinking of a number between 1 and 100%n");
        System.out.format("I'll give you 8 guesses%n");
        System.out.format("Guess: ");
        play();
    }

    private static void play() {
        do {
            getUsersGuess();
            validateUsersGuess(userInput);
        } while (!"GOOD GUESS!".equals(validation));
    }

    private static void getUsersGuess() {
        numberOfGuesses++;
        userInput = scanner.nextLine();
    }

    public static void validateUsersGuess(String input) {
        int guess = Integer.parseInt(input);

        //If a user guesses the number, the game should declare "GOOD GUESS!"
        if (guess < hiddenNumber) {
            validation = "HIGHER";
            System.out.printf("%s, Guess: ", validation);
        } else if (guess > hiddenNumber) {
            validation = "LOWER";
            System.out.printf("%s, Guess: ", validation);
        } else {
            validation = "GOOD GUESS!";
            System.out.printf("%s%n", validation);
        }
    }

}
