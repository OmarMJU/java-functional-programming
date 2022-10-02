package com.omju.excercises.streams;

public class Employes {
    private final String name;
    private final double salary;

    public Employes(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employes{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
