package baitap2610;

import java.util.*;
import java.util.stream.Collectors;

public class Bai3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("An", 85),
            new Student("Binh", 45),
            new Student("Chi", 92),
            new Student("Dung", 67),
            new Student("Em", 38)
        );

        Map<String, List<Student>> result = students.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Pass" : "Fail"));

        System.out.println("Danh sach hoc sinh theo nhom:");
        result.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach(s -> System.out.println("  " + s));
        });
    }
}

