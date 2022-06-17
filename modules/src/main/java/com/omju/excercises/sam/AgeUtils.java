package com.omju.excercises.sam;

import java.util.function.Function;
import java.time.LocalDate;
import java.time.Period;

public class AgeUtils {
    public static void main(String[] args) {
        try {
            System.out.println("A person that born in 1991 is " + calculateAge(9, 6, 1991) + " years old!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer calculateAge(Integer day, Integer month, Integer year) {
        AgeFunction<Integer, Integer, Integer, Integer> calculate = (dayF, monthF, yearF) -> Period.between(parseDate(dayF, monthF, yearF), LocalDate.now()).getYears();
        return calculate.apply(day, month, year);
    }

    private static LocalDate parseDate(Integer day, Integer month, Integer year) {
        AgeFunction<Integer, Integer, Integer, LocalDate> parser = (dayF, monthF, yearF) -> LocalDate.parse(yearF + "-" + addZeros(monthF) + "-" + addZeros(dayF));
        return parser.apply(day, month, year);
    }

    private static String addZeros(Integer dayMonth) {
        Function<Integer, String> zeros = day -> day < 10 ? "0" + day : String.valueOf(day);
        return zeros.apply(dayMonth);
    }

    @FunctionalInterface
    interface AgeFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
