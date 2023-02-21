package grades.data;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StudentDb {

    private final LocalDate FIRST_DAY_CLASS = LocalDate.of(2022, Month.NOVEMBER, 17);

    private final Map<String, String> usernamesMap;

    private final Random random = new Random();

    private List<LocalDate> classDates;

    public StudentDb() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        final String PATH = "src/main/resources/students.yml";
        FileInputStream inputStream = new FileInputStream(PATH);
        Object data = yaml.load(inputStream);
        usernamesMap = (Map<String, String>) data;
        setClassDates();
    }

    public Map<String, String> getUsernamesMap() {
        return usernamesMap;
    }

    public int size() {
        return usernamesMap.size();
    }

    public List<String> generateAbsences(int numberOfAbsences) {
        List<String> absences = new ArrayList<>();
        for (int i = 0; i < numberOfAbsences; i++) {
            absences.add(
                    String.valueOf(FIRST_DAY_CLASS.plusDays(random.nextInt(classDates.size() - 1)))
            );
        }
        return absences;
    }

    public List<Integer> generateGrades(int numberOfGrades) {
        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < numberOfGrades; i++) {
            grades.add(random.nextInt(65, 101));
        }
        return grades;
    }

    public String getRandomGithubUsername() {
        return this.getUsernamesMap().keySet()
                .stream()
                .toList()
                .get(random.nextInt(this.size()));
    }

    private void setClassDates() {
        this.classDates = FIRST_DAY_CLASS.datesUntil(LocalDate.now())
                .toList()
                .stream()
                .filter(date -> !DayOfWeek.SATURDAY.equals(date.getDayOfWeek())
                        && !DayOfWeek.SUNDAY.equals(date.getDayOfWeek()))
                .toList();
    }

    public List<LocalDate> getClassDates() {
        return classDates;
    }

}
