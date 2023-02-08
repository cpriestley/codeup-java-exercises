import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args) {


        System.out.format("Print 5 to 15:%n");
        for (int i = 5; i <= 15; i++) {
            System.out.println(i);
        }

        System.out.format("%nPrint Squares From 2 While value is less than 1,000,000:%n");
        for (long j = 2; j < 1000000; j*=j) {
            System.out.println(j);
        }

        fizzBuzz();

        Scanner scanner = new Scanner(System.in);

        String userContinue;

        do {
            System.out.format("%nHow many squares would you like to see? ");
            String userInt = scanner.nextLine();
            displayTableOfPowers(Integer.parseInt(userInt));
            System.out.format("%nWould you like to continue? [y/n] ");
            userContinue = scanner.nextLine();
        } while ("y".equals(userContinue.toLowerCase().substring(0, 1)));

        scanner.close();

    }

    private static void displayTableOfPowers(int parseInt) {
        System.out.format("%nHere is your table!%n");
        System.out.format("""
                          number | squared | cubed
                          ------ | ------- | -----
                          """);
        for (int i = 1; i <= parseInt; i++) {
            System.out.format("%7d|%7d|%5d%n", i, (i*i), (i*i*i));
        }
    }

    public static void fizzBuzz() {

        /*
        Write a program that prints the numbers from 1 to 100.
        For multiples of three: print “Fizz” instead of the number.
        For the multiples of five: print “Buzz”.
        For numbers which are multiples of both three and five: print “FizzBuzz”.
        */

        System.out.format("%nFizzBuzz:%n");
        for (int i = 1; i <= 100; i++) {
            if (i % (3 * 5)  == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
