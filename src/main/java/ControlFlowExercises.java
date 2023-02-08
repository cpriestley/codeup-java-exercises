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

        do {
            System.out.format("%nPlease enter a numerical number grade (0-100): ");
            String numberGrade = scanner.nextLine();
            String grade = getLetterGrade(Short.parseShort(numberGrade));
            System.out.format("You entered %s. The letter grade is %s%n", Short.parseShort(numberGrade), grade);
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

    /**
     * Grade Ranges:
     * A+	:	100 - 99
     * A	:	88-98
     * B+	:	87 - 86
     * B	:	85 - 80
     * C+	:	79 - 78
     * C	:	77 - 67
     * D+	:	66 - 65
     * D	:	64 - 60
     * F+	:	59 - 58
     * F	:	57 - 0
     */
    public static String getLetterGrade(short grade) {
        if(grade >= 99) {
            return "A+";
        } else if (grade >= 88) {
            return "A";
        } else if (grade >= 86) {
            return "B+";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 78) {
            return "C+";
        } else if (grade >= 67) {
            return "C";
        } else if (grade >= 65) {
            return "D+";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
