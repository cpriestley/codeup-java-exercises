package util;

public class InputTest {

    public static void main(String[] args) {
        Input input = new Input();

        do {
            double response = input.getDouble(1, 10, "Enter a decimal value between 1 and 10: ");
            System.out.format("Valid input. %f is between 1 and 10.%n", response);
            response = input.getDouble();
            System.out.format("Valid input. %f is a double %n", response);
            response = input.getInt(1, 10);
            System.out.format("Valid input. %f is between 1 and 10.%n", response);

        } while (input.yesNo());

    }
}