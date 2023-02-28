package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CohortTest {

    private Cohort cohort;
    private final Student STUDENT1 = new Student(1, "John Doe");
    private final Student STUDENT2 = new Student(2, "Jane Doe");
    private final Student STUDENT3 = new Student(3, "Suzy Que");
    private final Student NEW_STUDENT = new Student(4, "Johnny Come Lately");
    private final List<Student> STUDENTS = new ArrayList<>(List.of(STUDENT1, STUDENT2, STUDENT3));

    @BeforeEach
    void setUp() {
        cohort = new Cohort();
        STUDENTS.forEach(cohort::addStudent);
    }

    @Test
    void getCohortAverage() {
        int GRADE1 = 97;
        int GRADE2 = 98;
        int GRADE3 = 99;
        double GRADE_COUNT = 3.0;
        double average = (GRADE1 + GRADE2 + GRADE3) / GRADE_COUNT;
        STUDENT1.addGrade(GRADE1);
        STUDENT2.addGrade(GRADE2);
        STUDENT3.addGrade(GRADE3);
        assertEquals(average, cohort.getCohortAverage());
    }

    @Test
    void addStudent() {
        cohort.addStudent(NEW_STUDENT);
        assertEquals(NEW_STUDENT, cohort.getStudents().get(cohort.getStudents().size() - 1));
    }

    @Test
    void getStudents() {
        assertArrayEquals(STUDENTS.toArray(), cohort.getStudents().toArray());
    }

    @Test
    void getStudentById() {
        assertEquals(STUDENT1, cohort.getStudentById(1));
    }
}