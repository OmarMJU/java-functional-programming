package com.omju.excercises.reference_operator;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;

public class Students {
    private final  int id;
    private String name;
    private final double note;
    private final int telephoneNumber;

    public Students(int id, String name, double note, int telephoneNumber) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNote() {
        return note;
    }

    @SafeVarargs
    public static <T> List<T> getAllStudents(T... students) {
        return Arrays.asList(students);
    }

    public static Collection<Students> getAllApprovedStudents(List<Students> students) {
        return students.stream().filter(student -> student.getNote() >= 6).collect(Collectors.toList());
    }

    public static Collection<Students> getAllReprovedStudents(List<Students> students) {
        return students.stream().filter(student -> student.getNote() < 6).collect(Collectors.toList());
    }

    public static double calculateAverageTotal(Collection<Students> approved, Collection<Students> reproved) {
        double averageApproved = approved.stream().mapToDouble(Students::getNote).average().orElse(-1);
        double averageReproved = reproved.stream().mapToDouble(Students::getNote).average().orElse(-1);
        return averageApproved + averageReproved;
    }

    public static <R> R calculateAverage(Collection<Students> approved, Collection<Students> reproved, BiFunction<Collection<Students>, Collection<Students>, R> average) {
        return average.apply(approved, reproved);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note=" + note +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }
}