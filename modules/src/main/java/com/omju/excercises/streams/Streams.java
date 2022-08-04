package com.omju.excercises.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        try {
            Stream<String> myCourses = Stream.of("Java", "Lit", "English Basic", "iOS Development");
            Stream<Integer> courseLength = myCourses.map(String::length);
            Optional<Integer> longest = courseLength.max((courseA, courseB) -> courseA - courseB);
            longest.ifPresent(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
