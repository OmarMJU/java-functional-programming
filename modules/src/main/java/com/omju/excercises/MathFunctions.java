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


        // -- Expression Lambda Example from interface ICalculable. --
        ICalculable calculatorSum = (a, b) -> {
            System.out.println("--> SUM: This an implementation from operation method. The result is " + (a + b) + " <--");
        };
        calculatorSum.operation(5, 6);

        ICalculable calculatorRes = (a, b) -> {
            System.out.println("--> RES: This an implementation from operation method. The result is " + (a - b) + " <--");
        };
        calculatorRes.operation(10, 4);

        ICalculable calculatorMul = (a, b) -> {
            System.out.println("--> MUL: This an implementation from operation method. The result is " + (a * b) + " <--");
        };
        calculatorMul.operation(5, 5);

        ICalculable calculatorDiv = (a, b) -> {
            System.out.println("--> DIV: This an implementation from operation method. The result is " + (a / b) + " <--");
        };
        calculatorDiv.operation(10, 2);



        // -- Another example more complex from lambda functions. --
        int number = 5;
        System.out.println("The square of the number " + number + " is " + square.apply(5));

        Function<Integer, Integer> myFunction = dataIn -> {
            return dataIn * dataIn;
        };

        System.out.println(myFunction.apply(8));
    }
}
