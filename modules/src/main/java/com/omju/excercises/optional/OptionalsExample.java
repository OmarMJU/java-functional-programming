package com.omju.excercises.optional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
import java.util.Random;

public class OptionalsExample {
    public static void main(String[] args) {
        example1();
        example2();
    }

    private static void example1() {
        System.out.println("==========================");
        System.out.println("==== E X A M P L E  1 ====");
        System.out.println("==========================");

        System.out.println("==== Example 1.1: Return Nullables ====");
        Optional<List<String>> allNamesNull = getOptionalNamesNullable();
        allNamesNull.ifPresent(names -> names.forEach(System.out::println));

        System.out.println("==== Example 1.2: Return Empty ====");
        Optional<List<String>> namesEmpty = getOptionalNamesEmpty();
        namesEmpty.ifPresent(names -> names.forEach(System.out::println));

        System.out.println("==== Example 1.3: Return Datas ====");
        Optional<List<String>> namesDatas = getAllNames();
        namesDatas.ifPresent(names -> names.forEach(System.out::println));
    }

    private static void example2() {
        System.out.println("\n\n==========================");
        System.out.println("==== E X A M P L E  2 ====");
        System.out.println("==========================");

        System.out.println("==== Example 2.1: Return Optional Empty ====");
        String name = getName().orElseGet(() -> "No datas");
        System.out.println("The value is " + name);
    }

    private static Optional<List<String>> getOptionalNamesNullable() {
        List<String> nameList = new ArrayList<>();
        return Optional.ofNullable(nameList);
    }

    private static Optional<List<String>> getOptionalNamesEmpty() {
        return Optional.empty();
    }

    private static Optional<List<String>> getAllNames() {
        List<String> names = new ArrayList<>();
        names.add("Omar");
        names.add("Daniela");

        return Optional.of(names);
    }

    private static Optional<String> getName() {
        Random random = new Random();
        int min = 1, max = 10;
        int value = random.nextInt(max + min) + min;
        return value >= 5 ? Optional.of("Datas") : Optional.empty();
    }
}