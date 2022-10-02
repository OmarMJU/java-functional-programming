package com.omju.excercises.streams;

import java.util.stream.Stream;
import java.util.Optional;

public class Streams {
    public static void main(String[] args) {
        try {
            System.out.println("=========== EXAMPLE 1 ===========");
            Stream<String> myCourses = Stream.of("Java", "Lit", "English Basic", "iOS Development");
            Stream<Integer> courseLength = myCourses.map(String::length);
            Optional<Integer> longest = courseLength.max((courseA, courseB) -> courseA - courseB);
            longest.ifPresent(System.out::println);

            example2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void example2() {
        System.out.println("=========== EXAMPLE 2 ===========");
        Employes employee1 = new Employes("Omar Juarez", 30000);
        Employes employee2 = new Employes("Daniela Zamudio", 35200);
        Employes employee3 = new Employes("James Hetfield", 25500);
        Employes employee4 = new Employes("Elton John", 20000);
        Employes employee5 = new Employes("Anthony Start", 45100);
        Employes employee6 = new Employes("Rebeca Smith", 19500);
        Employes employee7 = new Employes("Francisco Ger", 11400);
        Employes employee8 = new Employes("Super Sonic", 12200);

        Stream<Employes> employees = Stream.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8);
        viewDatasStream(employees.filter(employee -> employee.getSalary() >= 30000)).forEach(System.out::println);
    }

    private static <T> Stream<T> viewDatasStream(Stream<T> stream) {
        return stream.peek(data -> System.out.println("Data: " + data));
    }
}