package movies;

import util.Input;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MovieApplication {

    public static void main(String[] args) {
        Movie[] movies = MoviesArray.findAll();
        String[] categories = {"all", "animated", "drama", "horror", "scifi"};
        Input input = new Input();

        do {
            System.out.format("What would you like to do?%n" +
                    "0 - view all movies%n" +
                    "1 - view movies in the animated category%n" +
                    "2 - view movies in the drama category%n" +
                    "3 - view movies in the horror category%n" +
                    "4 - view movies in the scifi category%n" +
                    "5 - add a new movie%n" +
                    "Enter your choice: ");
            int choice = input.getInt(0, categories.length);
            if (choice == categories.length)
                movies = addMovie(movies, categories, input);
            else
                displayCategory(movies, categories[choice]);
        } while (input.yesNo());

        System.out.println("Goodbye!");

    }

    private static Movie[] addMovie(Movie[] movies, String[] categories, Input input) {
        Movie movie = createMovie(categories, input);
        System.out.format("%n%s has been added to %s%n", movie.getName(), movie.getCategory());
        movies = Arrays.copyOf(movies, movies.length + 1);
        movies[movies.length - 1] = movie;
        return movies;
    }

    private static Movie createMovie(String[] categories, Input input) {

        String name;
        do {
            name = input.getString("Enter the movie name: ");
        } while (name.trim().isEmpty());

        String category;
        do {
            String cats = Arrays.stream(categories)
                    .filter(c -> !"all".equals(c))
                    .toList()
                    .toString();
           category = input.getString(String.format("Enter the movie category %s: ", cats));
        } while (category.isEmpty() || !Arrays.asList(categories).contains(category));

        return new Movie(name, category.toLowerCase());
    }

    private static void displayCategory(Movie[] movies, String category) {
        String regex = !"all".equals(category) ? String.format("^%s$", category) : ".*";
        System.out.format("%n%s Movies:%n", properCase(category));
        Arrays.stream(movies)
                .filter(m -> Pattern.matches(regex, m.getCategory()))
                .forEach(m -> System.out.format("%s -- %s%n", m.getName(), m.getCategory()));
    }

    private static String properCase(String category) {
        return category.substring(0, 1).toUpperCase() + category.substring(1);
    }
}