package grades;

import grades.data.StudentDb;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import util.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class GradesApp {

    public static final int MAX_NUMBER_OF_ABSENCES = 5;
    static Random random = new Random();

    private static Map<String, Student> students;

    private static StudentDb db;

    private static double classGPA;

    public static void main(String[] args) {

        try {
            db = new StudentDb();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        students = new HashMap<>();

        try (Input input = new Input()) {
            System.out.format("""
                                    
                    This is a Grades Application Demo that displays GPA for Code Up students.
                    It randomly generates grades between 65 and 100.
                    You can choose how many grades our students will have.
                                    
                    """);
            int numberOfGrades = (int) input.getDouble("How many grades should we initialize each student with? ");

            for (int i = 0; i < 7; i++) {
                String username = db.getRandomGithubUsername();
                String name = db.getUsernamesMap().get(username);
                importStudentsAndGrades(
                        username,
                        new Student(name, username),
                        numberOfGrades);
            }

            setClassGPA();

            String menu = String.join("| |", students.keySet());

            System.out.format("""
                                    
                    Welcome!
                    """);

            app(input, menu);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void app(Input input, String menu) throws IOException {

        do {
            printMenu();

            int choice = input.getInt(0, 4);

            switch (choice) {
                case 0 -> {System.out.format("%nGoodbye...%n"); return;}
                case 1 -> displayAllStudents();
                case 2 -> displayClassGPA();
                case 3 -> chooseAndDisplaySpecificStudent(input, menu);
                case 4 -> createCSVFile();
            }

        } while (input.yesNo());

        System.out.format("%nGoodbye...%n");

    }

    public static void createCSVFile() throws IOException {
        File file = new File("students.csv");
        FileWriter out = new FileWriter(file);
        CSVFormat csvFormat = CSVFormat.EXCEL
                .builder()
                .setHeader(new String[]{"Name", "Github", "GPA"}).build();
        try (CSVPrinter printer = new CSVPrinter(out, csvFormat)) {
            for (Map.Entry<String, Student> entry : students.entrySet()) {
                Student s = entry.getValue();
                printer.printRecord(s.getName(), s.getUserName(), s.getGradeAverage());
            }
        }
        System.out.println("Student Data Exported to " + file.getPath());
        out.close();
    }

    private static void printMenu() {
        System.out.format("""
                                    
                Please Choose an Action
                0. Exit
                1. Display All Students
                2. Display Class GPA
                3. Display a specific student's GPA
                4. Export Student Data to CSV
                                       
                """);
    }

    private static void chooseAndDisplaySpecificStudent(Input input, String menu) {
        Student student = chooseStudent(input, menu);
        if (student != null) {
            displayStudent(student);
        }
    }

    private static Student chooseStudent(Input input, String menu) {
        Student student = null;
        System.out.format("""
                What student would you like to see more information on?
                                
                |%s|
                                
                user:\s""", menu);

        String username = input.getString();

        if (students.containsKey(username)) {
            student = students.get(username);
        } else {
            System.out.format("%nSorry, no student found with the GitHub username of \"%s\".%n", username);
        }
        return student;
    }

    private static void displayAllStudents() {
        students.forEach((key, value) -> displayStudent(value));
    }

    private static void displayStudent(Student student) {
        System.out.println(student);
    }

    private static void importStudentsAndGrades(String username, Student student, int numberOfGrades) {
        students.put(username, student);
        db.generateGrades(numberOfGrades)
                .forEach(student::addGrade);
        db.generateAbsences(random.nextInt(MAX_NUMBER_OF_ABSENCES))
                .forEach(date -> student.recordAttendance(date, "A"));
        db.getClassDates()
                .forEach(date -> student.recordAttendance(String.valueOf(date), "P"));
    }

    private static void setClassGPA() {
        double totalPoints = 0;
        int gradeCount = 0;
        for (Integer grade : getAllStudentGrades()) {
            totalPoints += grade;
            gradeCount++;
        }
        classGPA = totalPoints / gradeCount;
    }

    private static void displayClassGPA() {
        System.out.format("""
                Class GPA: %2.2f
                Grades:    [%s]
                """, classGPA, getStudentGradesAsCsv());
    }

    private static String getStudentGradesAsCsv() {
        return getAllStudentGrades().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static List<Integer> getAllStudentGrades() {
        //return as of the students grades as a string
        return students.values().stream()
                .flatMapToInt(student -> student.getGrades().stream().mapToInt(Integer::intValue))
                .boxed()
                .collect(Collectors.toList());
    }

}
