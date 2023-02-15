package grades;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Student {

    private final String name;
    private final List<Double> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    // returns the student's name
    public String getName() {
        return name;
    }
    // adds the given grade to the grades property
    public void addGrade(double grade) {
        grades.add(grade);
    }

    // returns the average of the students grades
    public double getGradeAverage() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .sum() / grades.size();
    }

}
