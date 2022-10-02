package com.omju.excercises.streams;

import com.omju.excercises.reference_operator.Students;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.util.UtilStudents;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        try {
            Stream<Students> students = UtilStudents.getRandomStudents(52);
            List<String> studentsApproved = students.filter(student -> student.getNote() >= 6.0).map(students1 -> students1.getName() + ": Approved.").distinct().collect(Collectors.toList());

            System.out.println("Students approved: " + studentsApproved.size());
            studentsApproved.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
