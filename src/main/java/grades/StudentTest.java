package grades;

import java.util.Arrays;

public class StudentTest {

    public static void main(String[] args) {
        Student stud = new Student("clayton", "cpriestley");

        int[] grades = {100, 91, 97, 89, 88};

        for (int grade : grades) {
            stud.addGrade(grade);
        }

        System.out.format("%s's grades: %s%n", stud.getName(), Arrays.toString(grades));
        System.out.format("%s's grade point average: %s%n", stud.getName(), stud.getGradeAverage());

    }
}
