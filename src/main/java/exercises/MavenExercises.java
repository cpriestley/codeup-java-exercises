package exercises;

import org.apache.commons.lang3.StringUtils;
import util.Input;

public class MavenExercises {
    public static void main(String[] args) {

        try(Input input = new Input()) {
            String response = input.getString("Enter a string: ");
            boolean isNumber = StringUtils.isNumeric(response);
            System.out.println("You entered: " + response);
            if (isNumber) {
                System.out.printf("\"%s\" is a number!%n", response);
            } else {
                System.out.printf("\"%s\" is not a number!%n", response);
            }
            System.out.println("Flipped Case: " + StringUtils.swapCase(response));
            System.out.println("Reversed: " + StringUtils.reverse(response));
        }
    }
}
