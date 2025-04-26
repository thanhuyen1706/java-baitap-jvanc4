package baitap2610;

import java.util.*;

public class Bai2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", 85),
            new Student("Binh", 45),
            new Student("Chi", 92),
            new Student("Dung", 67),
            new Student("Em", 38)
        );

        double avgScore = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);
        System.out.println("Diem trung binh ca lop: " + avgScore);
    }
}
