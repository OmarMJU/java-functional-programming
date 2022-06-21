package com.omju.excercises.reference_operator;

import java.util.stream.Collectors;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;

public class Students {
    private int id;
    private String name;
    private double note;
    private int telephoneNumber;

    public Students() {}

    public Students(int id, String name, double note, int telephoneNumber) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setNote(int note) {
        this.note = note;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public static  <T> List<T> getAllStudents(T... students) {
        return Arrays.asList(students);
    }

    public static Collection<Students> getAllApprovedStudents(List<Students> students) {
        return students.stream().filter(student -> student.getNote() >= 6).collect(Collectors.toList());
    }

    public static Collection<Students> getAllReprovedStudents(List<Students> students) {
        return students.stream().filter(student -> student.getNote() < 6).collect(Collectors.toList());
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
