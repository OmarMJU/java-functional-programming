package com.omju.excercises.operators_bigfunction;

import java.util.function.UnaryOperator;
import java.util.function.BiFunction;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringFunctions {
    private static final String[] MONTHS = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final String QUOTE = "\"";

    public static void main(String[] args) {
        UnaryOperator<String> textWithQuote = text -> QUOTE + text + QUOTE;
        String result = textWithQuote.apply("This a text with quotes");
        System.out.println(result);

        BiFunction<Integer, String, Date> makeDate = (day, month) -> {
            int monthNumber = Arrays.asList(MONTHS).indexOf(month.toUpperCase());
            Calendar calendar = Calendar.getInstance();
            calendar.set(2022, monthNumber, day);
            return calendar.getTime();
        };

        System.out.println(sdf.format(makeDate.apply(12, "march")));
        System.out.println(addSpacesLeft("Omar", 10));
        System.out.println(addSpacesRight("Omar", 10));
    }

    private static String addSpacesLeft(String text, Integer spaces) {
        BiFunction<String, Integer, String> addSpaces = (textF, numSpaces) -> String.format("%" + numSpaces + "s", textF);
        return addSpaces.apply(text, spaces);
    }

    private static String addSpacesRight(String text, Integer spaces) {
        BiFunction<String, Integer, String> addSpaces = (textF, numSpaces) -> String.format("%" + (-numSpaces) + "s", textF);
        return addSpaces.apply(text, spaces);
    }
}