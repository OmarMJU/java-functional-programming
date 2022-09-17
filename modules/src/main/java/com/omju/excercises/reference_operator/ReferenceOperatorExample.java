package com.omju.excercises.reference_operator;

import com.util.UtilStudents;

import java.util.function.Consumer;
import java.util.Collection;
import java.util.List;

/**
 * References:
 * https://www.geeksforgeeks.org/double-colon-operator-in-java/
 * https://www.baeldung.com/java-8-double-colon-operator
 * https://mkyong.com/java8/java-8-method-references-double-colon-operator/
 * https://www.arquitecturajava.com/java-stream-map-y-estadisticas/
 * https://mkyong.com/java8/java-8-streams-map-examples/
 */
public class ReferenceOperatorExample {
    public static void main(String[] args) {
        List<Students> students = UtilStudents.generateRandomStudents(10);

        System.out.println("\n******* The first way to show the students *******");
        Consumer<Students> getStudents = student -> System.out.println(student);
        students.forEach(getStudents);

        System.out.println("\n******* The second way to show the students *******");
        students.forEach(student -> System.out.println(student));

        System.out.println("\n******* The third way to show the students *******");
        students.forEach(System.out::println);

        System.out.println("\n\n========== All approved students ==========");
        Collection<Students> approvedStudents = Students.getAllApprovedStudents(students);
        approvedStudents.forEach(System.out::println);
        approvedStudents.forEach(student -> System.out.println("Name: " + student.getName() + ", note: " + student.getNote()));

        System.out.println("\n\n========== All reproved students ==========");
        Collection<Students> reprovedStudents = Students.getAllReprovedStudents(students);
        reprovedStudents.forEach(System.out::println);
        reprovedStudents.forEach(student -> System.out.println("Name: " + student.getName() + ", note: " + student.getNote()));

        System.out.println("\n\n######### Student's notes average #########");
        double average = Students.calculateAverage(approvedStudents, reprovedStudents, Students::calculateAverageTotal);
        System.out.println("The average is " + average);
    }
}