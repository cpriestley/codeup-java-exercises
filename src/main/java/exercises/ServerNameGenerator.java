package exercises;

public class ServerNameGenerator {
    String[] adjectives = {"big", "small", "red", "blue", "green", "yellow", "purple", "orange", "black", "white"};
    String[] nouns = {"dog", "cat", "bird", "fish", "mouse", "snake", "lizard", "frog", "turtle", "hamster"};

    public static void main(String[] args) {
        ServerNameGenerator serverNameGenerator = new ServerNameGenerator();
        String serverName = serverNameGenerator.randomElement(serverNameGenerator.adjectives) + "-"
                + serverNameGenerator.randomElement(serverNameGenerator.nouns);
        System.out.format("Here is your server name: %n%s%n", serverName);
    }

    private String randomElement(String[] words) {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
