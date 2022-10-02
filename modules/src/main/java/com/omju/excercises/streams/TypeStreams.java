package com.omju.excercises.streams;

import java.util.stream.IntStream;

public class TypeStreams {
    public static void main(String[] args) {
        IntStream myIntStream = IntStream.iterate(0, x -> x + 1);
        myIntStream.limit(1000).parallel().filter(x -> x % 2 == 0).forEachOrdered(System.out::println);
    }
}
