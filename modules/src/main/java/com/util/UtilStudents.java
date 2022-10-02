package com.util;

import com.omju.excercises.reference_operator.Students;
import com.github.javafaker.Faker;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class UtilStudents {
    private static final int MIN = 0;
    private static Random random;
    private static Faker faker;

    public static Stream<Students> getRandomStudents(int numStudents) {
        return generateRandomStudents(numStudents).stream();
    }

    private static double generateRandomNote() {
        int max = 11;
        random = new Random();
        return random.nextInt(max + MIN) + MIN;
    }

    private static int generateRandomId() {
        int max = 50;
        random = new Random();
        return random.nextInt(max + MIN) + MIN;
    }

    private static String generateRandomTelephoneNumber() {
        faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }

    private static  String generateRandomName() {
        faker = new Faker();
        return faker.name().fullName();
    }

    public static List<Students> generateRandomStudents(int numberStudents) {
        List<Students> students = new ArrayList<>();
        Students student;

        for(int i = 0; i < numberStudents; i++) {
            student = new Students(generateRandomId(), generateRandomName(), generateRandomNote(), generateRandomTelephoneNumber());
            students.add(student);
        }

        return students;
    }
}