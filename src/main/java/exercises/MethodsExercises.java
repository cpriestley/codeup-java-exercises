package exercises;

import java.text.NumberFormat;
import java.util.Scanner;

public class MethodsExercises {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long result;
        //Addition
        addition(10, 5);
        //Subtraction
        subtraction(10, 5);
        //Multiplication
        multiplication(10, 5);
        //Multiplication Loop
        multiplicationLoop(10, 5);
        //Multiplication Dynamic
        multiplicationDynamic(10, 5);
        //Division
        division(10, 5);
        //Modulus
        modulus(10, 5);
        //User input validation
        System.out.print("Enter a number between 1 and 10: ");
        result = getInteger(1, 10);
        System.out.format("Valid input. %d is between 1 and 10.%n", result);
        //Factorial
        factorial();
        //Simulate rolling 2 n-sided dice
        diceSimulation();
        scanner.close();
    }

    public static long addition(int a, int b) {
        long result = a + b;
        System.out.format("%d + %d = %d%n", a, b, result);
        return result;
    }

    public static long subtraction(int a, int b) {
        long result = a - b;
        System.out.format("%d - %d = %d%n", a, b, result);
        return result;
    }

    public static long multiplication(int a, int b) {
        long result = (long) a * b;
        System.out.format("%d * %d = %d (normal)%n", a, b, result);
        return result;
    }

    public static long multiplicationLoop(int a, int b) {
        long result = 0;
        for (int i = 0; i < b; i++) {
            result += a;
        }
        System.out.format("%d * %d = %d (loop)%n", a, b, result);
        return result;
    }

    public static long multiplicationDynamic(int a, int b) {
        long result = multiplicationRecurse(10, 5);
        System.out.format("%d * %d = %d (recursive)%n", 10, 5, result);
        return result;
    }

    public static long multiplicationRecurse(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + multiplicationRecurse(a, b - 1);
    }

    public static long division(int a, int b) {
        long result = a / b;
        System.out.format("%d / %d = %d%n", a, b, result);
        return result;
    }

    public static long modulus(int a, int b) {
        long result = a % b;
        System.out.format("%d %% %d = %d%n", a, b, result);
        return result;
    }

    public static int getInteger(int min, int max) {
        System.out.format("Enter a whole number between %d and %d: ", min, max);
        String nextLine = scanner.nextLine();
        nextLine = nextLine.isEmpty() ? String.valueOf(min-1): nextLine;
        int userInput = Integer.parseInt(nextLine);
        if (userInput < min || userInput > max) {
            System.out.format("Invalid input. Please enter a number between %d and %d.%n", min, max);
            return getInteger(min, max);
        }
        return userInput;
    }

    public static int getDiceSides() {
        System.out.format("Enter the number of sides of your dice: ");
        return Integer.parseInt(scanner.nextLine());
    }


    //Calculate the factorial of a number.
    public static void factorial() {
        String userContinue;
        do {
            int n = getInteger(1, 20);
            System.out.format("!%d = %s", n, NumberFormat.getInstance().format(f(n)));
            System.out.format("%nWould you like to continue? [y/n] ");
            userContinue = scanner.nextLine();
        } while (isUserToContinue(userContinue));
    }

    private static boolean isUserToContinue(String userContinue) {
        if (userContinue.length() > 0) {
            return !"n".equals(userContinue.toLowerCase().substring(0, 1));
        }
        return true;
    }

    public static long f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static void diceSimulation() {
        String userContinue;
        do {
            int sides = getDiceSides();
            int die1 = (int) ((Math.random() * sides) + 1);
            int die2 = (int) ((Math.random() * sides) + 1);
            System.out.format("Dice: %d and %d%n", die1, die2);
            System.out.format("%nWould you like to continue? [y/n] ");
            userContinue = scanner.nextLine();
        } while (isUserToContinue(userContinue));
    }

}