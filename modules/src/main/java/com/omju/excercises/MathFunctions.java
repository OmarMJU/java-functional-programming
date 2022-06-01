package com.omju.excercises;

import java.util.function.Function;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer number) {
                return number * number;
            }
        };

        int number = 5;
        System.out.println("The square of the number " + number + " is " + square.apply(5));
    }
}
