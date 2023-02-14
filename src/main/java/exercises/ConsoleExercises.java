package exercises;

import java.util.Scanner;

public class ConsoleExercises {
    public static void main(String[] args) {
        double pi = 3.14159;
        System.out.format("The value of pi is approximately %.2f.%n", pi);
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter an integer: ");
        int userInt = scanner.nextInt();
        System.out.format("You entered %d%n", userInt);

        System.out.println("Please enter three words");
        String word1 = scanner.next();
        String word2 = scanner.next();
        String word3 = scanner.next();

        scanner.nextLine();

        System.out.format("You entered:%n%s%n%s%n%s%n", word1, word2, word3);

        System.out.println("Please enter a sentence");

        String sentence = scanner.nextLine();
        System.out.println(sentence);

        System.out.format("Please enter the length and width of the Codeup classroom%nLength: ");
        String length = scanner.nextLine();
        System.out.print("Width: ");
        String width = scanner.nextLine();
        float area = Float.parseFloat(length) * Float.parseFloat(width);
        float perimeter = Float.parseFloat(length) * 2 + Float.parseFloat(width) * 2;
        System.out.format("The perimeter is %.2f feet and the area is %.2f square feet.", area, perimeter);
        scanner.close();
    }
}
