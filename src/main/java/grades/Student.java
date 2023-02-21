package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Student {

    private final String name;
    private final String userName;
    private final List<Integer> grades;
    private final Map<String, String> attendance;

    public Student(String name, String userName) {
        this.name = name;
        this.userName = userName;
        grades = new ArrayList<>();
        attendance = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getGradeAverage() {
        return grades.stream()
                .mapToDouble(Integer::intValue)
                .sum() / grades.size();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void recordAttendance(String date, String value) {
        if (Pattern.matches("\\d{4}-\\d{2}-\\d{2}", date)) {
            attendance.putIfAbsent(date, value);
        } else {
            System.out.format("Invalid Date String: %s does not match pattern yyyy-mm-dd%n", date);
        }
    }

    public double calculateAttendance() {
        double daysMissed = getMissedDates().size();
        double totalDays = attendance.size();
        return (totalDays - daysMissed) / totalDays * 100;
    }

    public List<String> getMissedDates() {
        return attendance.entrySet()
                .stream()
                .filter(e -> "A".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("""
                        
                        Name:       %s
                        Github:     %s
                        GPA:        %.2f
                        Grades:     %s
                        Attendance: %.2f
                        Absences:   %s
                        """,
                name, userName, getGradeAverage(), grades, calculateAttendance(), getMissedDates());
    }
}
