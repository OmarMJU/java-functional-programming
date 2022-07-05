package com.omju.excercises.defaul_methods;

import java.util.function.Predicate;

public class DataBaseUtils {
    private static final String REPLACE_PATTERN = "{$params}";

    public static void main(String[] args) {
        DataBase myDataBase = (query, params) -> !query.replace(REPLACE_PATTERN, params).equals("");
        myDataBase.query("select * from costumers where costumer_id = " + REPLACE_PATTERN, "1235");
        myDataBase.dbConnection("jdbc://mydatabase:omju:omajis:5112", "select * from costumers where costumer_id = " + REPLACE_PATTERN, "1235");
    }

    @FunctionalInterface
    interface DataBase {
        boolean query(String query, String params);

        default void dbConnection(String url, String query, String params) {
            Predicate<String> connectionSuccess = urlConnection -> urlConnection.contains("jdbc");

            if (connectionSuccess.test(url)) {
                if (query(query, params)) {
                    System.out.println("Query execute successfully!!");
                } else {
                    System.out.println("Something fail!!");
                }
            } else {
                System.out.println("Connection refuse!!");
            }
        }
    }
}
