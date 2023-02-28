package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    Student student;
    private final int ID = 1;
    private final String NAME = "John Doe";
    private final int GRADE1 = 97;
    private final int GRADE2 = 98;
    private final int GRADE3 = 99;
    private double average;
    private final List<Integer> GRADES = new ArrayList<>(List.of(GRADE1, GRADE2, GRADE3));

    @BeforeEach
    void setUp() {
        student = new Student(ID, NAME);
        for (Integer grade : GRADES) {
            student.addGrade(grade);
        }
        double GRADE_COUNT = 3.0;
        average = (GRADE1 + GRADE2 + GRADE3) / GRADE_COUNT;
    }

    @Test
    void getId() {
        assertEquals(ID, student.getId());
    }

    @Test
    void getName() {
        assertEquals(NAME, student.getName());
    }

    @Test
    void getGrades() {
        assertArrayEquals(GRADES.toArray(), student.getGrades().toArray());
    }

    @Test
    void addGrade() {
        int GRADE4 = 100;
        student.addGrade(GRADE4);
        assertEquals(GRADE4, student.getGrades().get(student.getGrades().size() - 1));
    }

    @Test
    void getGradeAverage() {
        assertEquals(average, student.getGradeAverage());
    }

}