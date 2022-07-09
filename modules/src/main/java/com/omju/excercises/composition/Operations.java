package com.omju.excercises.composition;

import java.util.function.Function;

public class Operations {
    public static void main(String[] args) {
        System.out.println("===== EXAMPLE 1 =====");
        Function<Integer, Integer> operation1 = x -> {
            System.out.println("Inner operation 1 function");
            return x * 3;
        };

        // El método compose ejecuta la función en la que fue definida y después ejecuta la función en la cual se mandó a llamar.
        Function<Integer, Integer> operation2 = operation1.compose(y -> {
            System.out.println("Inner operation 2 function");
            return y - 1;
        });

        // El método andThen ejecuta primero la función en la cual se llama el método y después en la que fue definida.
        Function<Integer, Integer> operation3 = operation2.andThen(z -> {
            System.out.println("Inner operation 3 function");
            return z * z;
        });

        System.out.println("The result is: " + operation3.apply(5));

        System.out.println("\n\n===== EXAMPLE 2 =====");
        Function<String, String> operation1ConnectionVerify = url -> {
            System.out.println("Operation 1: Verify the DB connection...");
            String[] dbString = url.split("\\|");

            if (dbString[0].contains("dbcDriver")) {
                return dbString[1];
            } else {
                return "";
            }
        };

        Function<String, Boolean> operation2ExecuteQuery = operation1ConnectionVerify.andThen(query -> {
            System.out.println("Operation 2: Execute query... ");
            return query.contains("with ur");
        });

        Function<String, Boolean> operation3CloseDB = operation2ExecuteQuery.andThen(isSuccess -> {
            if (isSuccess) {
                System.out.println("Operation 3: Connection closed!!");
                return true;
            }

            return false;
        });

        System.out.println("The result is: " + operation3CloseDB.apply("jdbcTemplate:dbcDriver:omju:omju90/1234|select * from costumer with ur"));
    }
}
