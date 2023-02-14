package util;

import java.util.Scanner;

import exercises.MethodsExercises;

public class Input {

    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString(String... prompt) {
        if( prompt.length > 0)
            System.out.format(prompt[0]);
        return scanner.nextLine();
    }

    public boolean yesNo() {
        return yesNo("%nWould you like to continue? [y/n] ");
    }

    public boolean yesNo(String prompt) {
        System.out.format(prompt);
        String response = getString();
        return "y".toLowerCase().equals(response) ||
                "yes".toLowerCase().equals(response) ||
                "sure".toLowerCase().equals(response) ||
                "ok".toLowerCase().equals(response) ||
                "yeah".toLowerCase().equals(response) ||
                "affirmative".toLowerCase().equals(response);
    }

    public int getInt(int min, int max) {
        return MethodsExercises.getInteger(min, max);
    }

    public double getDouble(String... prompt) {
        String msg;
        if (prompt.length > 0) {
            msg = prompt[0];
        } else {
            msg = "Enter a decimal value: ";
        }
        return getDouble(Double.MIN_VALUE, Double.MAX_VALUE, msg);
    }

    public double getDouble(double min, double max, String... prompt) {
        String output;
        if (prompt.length > 0) {
            output = prompt[0];
        } else {
            output = String.format("Enter a number between %s and %s: ", min, max);
        }
        System.out.format(output);
        double userInput = Double.parseDouble(getString());
        if (userInput < min || userInput > max) {
            System.out.format(output);
            return getDouble(min, max);
        }
        return userInput;
    }

}
