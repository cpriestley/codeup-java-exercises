package exercises;

import java.util.Scanner;

/**
 * exercises.Bob is a lackadaisical teenager. In conversation, his responses are very limited.
 */
public class Bob {

    public static void main(String[] args) {

        System.out.println("Hello, my name is exercises.Bob.");
        Scanner scanner = new Scanner(System.in);

        System.out.format("^ That's exercises.Bob. What would you like to say to exercises.Bob?%nSay 'bye' to end the conversation.%nYou: ");
        while (true) {
            String userInput = scanner.nextLine();
            bobResponse(userInput);
            if ("bye".equalsIgnoreCase(userInput)) {
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.print("You: ");
            }
        }

    }

    /**
     * exercises.Bob answers 'Sure.' if you ask him a question. (the input ends with a question mark)
     * He answers 'Whoa, chill out!' if you yell at him. (the input ends with an exclamation mark)
     * He says 'Fine. Be that way!' if you address him without actually saying anything. (empty input)
     * He answers 'Whatever.' to anything else.
     */
    public static void bobResponse(String input) {
        if (input.endsWith("?")) {
            System.out.println("exercises.Bob: Sure.");
        } else if (input.endsWith("!")) {
            System.out.println("exercises.Bob: Whoa, chill out!");
        } else if (input.isEmpty()) {
            System.out.println("exercises.Bob: Fine. Be that way!");
        } else {
            System.out.println("exercises.Bob: Whatever.");
        }
    }
}
