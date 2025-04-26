package baitap2610;
import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", 85),
            new Student("Binh", 45),
            new Student("Chi", 92),
            new Student("Dung", 67),
            new Student("Em", 38)
        );

        Student topStudent = students.stream()
                .max(Comparator.comparingInt(Student::getScore))
                .orElse(null);
        if (topStudent != null) {
            System.out.println("Hoc sinh co diem cao nhat: " + topStudent.getName() + " - " + topStudent.getScore());
        }

        System.out.println("Danh sach hoc sinh va diem:");
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
    }
}

