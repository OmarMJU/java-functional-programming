package com.omju.excercises.optional;

import java.util.Optional;

/**
 * References:
 * https://www.tutorialspoint.com/java8/java8_optional_class.htm
 * https://www.baeldung.com/java-optional
 * https://www.adictosaltrabajo.com/2015/03/02/optional-java-8/
 */
public class OptionalMath {
    public static void main(String[] args) {
        try {
            Integer value1 = null;
            Integer value2 = 10;

            Optional<Integer> a = Optional.ofNullable(value1);
            Optional<Integer> b = Optional.of(value2);

            System.out.println(sum(a, b));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("The parameter a is present? " + a.isPresent());
        System.out.println("The parameter b is present? " + b.isPresent());

        Integer value1 = a.orElse(0);
        Integer value2 = b.get();
        return value1 + value2;
    }
}