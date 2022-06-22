package com.omju.excercises.reference_operator;

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
        Students student1 = new Students(1, "Fulanito De Tal", 8.5, 1234567890);
        Students student2 = new Students(2, "Menganito De Tal", 10.0, 1234632134);
        Students student3 = new Students(3, "Perenganito De Tal", 4.5,1268742361);
        Students student4 = new Students(4, "Sutanito De Tal", 7.5, 1159876342);
        Students student5 = new Students(5, "Fulanita De Tal", 3.5, 1035973469);
        Students student6 = new Students(6, "Perenganita De Tal", 5.5, 13694736);
        Students student7 = new Students(7, "Menganita De Tal", 6.2, 100239736);
        Students student8 = new Students(8, "Sutanita De Tal", 4.3, 1111582148);
        Students student9 = new Students(9, "Alma Madero Rico", 9.1, 115973054);
        Students student10 = new Students(10, "Francisco Ger", 2.1, 100689136);

        List<Students> students = Students.getAllStudents(student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);

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