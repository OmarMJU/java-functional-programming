package com.omju.excercises.streams;

import com.omju.excercises.reference_operator.Students;
import java.util.stream.Stream;
import com.util.UtilStudents;

public class StreamPractice {
    public static void main(String[] args) {
        try {
            Stream<Students> students = UtilStudents.getRandomStudents(52);
            students.filter(student -> student.getNote() >= 6.0).map(students1 -> students1.getName() + ": Congratulations!!").distinct().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
