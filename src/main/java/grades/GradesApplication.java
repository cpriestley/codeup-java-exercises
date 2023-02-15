package grades;

import util.Input;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradesApplication {

    static Random random = new Random();

    private static Map<String, Student> students;

    private static final Map<String, String> usernamesMap = Stream.of(new String[][]{
                    {"cpriestley", "Clayton O. Priestley"},
                    {"jeremymwood", "Jeremy M. Wood"},
                    {"madmarcos-codeup", "Mark Robinson"},
                    {"nelsonymarie", "Misael Cuadrado"},
                    {"gushitig", "Christina Antonuccio"},
                    {"gardoJr873", "Edgardo Ortiz Jr"},
                    {"joe-vandzura", "Joe Vandzura"},
                    {"Kevin-Fowler17", "Kevin Fowler"},
                    {"anamoreno123", "Ana Moreno"},
                    {"Jennie-Smith", "Jennie Smith"},
                    {"josephmccomas", "Joseph"},
                    {"stalbot0", "Stephen Talbot"},
                    {"mcampbell379", "Mitchell Campbell"},
                    {"MattGuardiola", "Matt Guardiola"},
                    {"micah810", "Micah"},
                    {"AlexSchmerber", "Alex Schmerber"},
                    {"isaachern123", "Isaac Hernandez"},
                    {"andvarna99", "Andrea Varnado"},
                    {"Shawnhardin01", "Shawn Hardin"},
                    {"adam-michael-bishop", "Adam Bishop"},
                    {"BDorries", "Billie Dorries"}})
            .collect(Collectors.toMap(data -> data[0], data -> data[1]));


    public static void main(String[] args) {

        students = new HashMap<>();
        Input input = new Input();
        int numberOfGrades = (int) input.getDouble("How many grades should we initialize each student with? ");

        for (int i = 0; i < 7; i++) {
            String username;
            do {
                username = getRandomGithubUsername();
            } while (students.containsKey(username));

            addStudentAndGradesToMap(username, new Student(usernamesMap.get(username)), numberOfGrades);
        }

        String menu = String
                .join("| |", new ArrayList<>(students.keySet()));

        System.out.format("""
                                
                Welcome!
                                
                Here are the GitHub usernames of our students:
                """);

        app(input, menu);

    }

    public static void app(Input input, String menu) {

        do {
            System.out.format("""
                    
                    |%s|
                    
                    What student would you like to see more information on?
                    user:\s""", menu);

            String username = input.getString();

            if (students.containsKey(username)) {
                Student student = students.get(username);

                System.out.format("""
                                            
                        Name: %s - GitHub Username: %s
                        Current Average: %s
                        """, student.getName(), username, student.getGradeAverage());
            } else {
                System.out.format("%nSorry, no student found with the GitHub username of \"%s\".%n", username);
            }

        } while (input.yesNo());

        System.out.format("%nGoodbye...%n");

    }

    private static void addStudentAndGradesToMap(String username, Student student, int numberOfGrades) {
        students.put(username, student);
        generateGrades(numberOfGrades)
                .forEach(student::addGrade);
    }

    private static List<Integer> generateGrades(int numberOfGrades) {
        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < numberOfGrades; i++) {
            grades.add(random.nextInt(65, 101));
        }
        return grades;
    }

    private static String getRandomGithubUsername() {
        return usernamesMap.keySet()
                .stream()
                .toList()
                .get(random.nextInt(usernamesMap.size()));
        //return userNames[random.nextInt(userNames.length)];
    }

}
