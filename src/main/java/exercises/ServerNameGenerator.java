package exercises;

import java.util.Random;

public class ServerNameGenerator {
    String[] adjectives = {"big", "small", "red", "blue", "green", "yellow", "purple", "orange", "black", "white"};
    String[] nouns = {"dog", "cat", "bird", "fish", "mouse", "snake", "lizard", "frog", "turtle", "hamster"};

    Random random;

    public ServerNameGenerator() {
        random = new Random();
    }

    public static void main(String[] args) {
        ServerNameGenerator serverNameGenerator = new ServerNameGenerator();
        String serverName = serverNameGenerator.randomElement(serverNameGenerator.adjectives) + "-"
                + serverNameGenerator.randomElement(serverNameGenerator.nouns);
        System.out.format("Here is your server name: %n%s%n", serverName);
    }

    private String randomElement(String[] words) {
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}
