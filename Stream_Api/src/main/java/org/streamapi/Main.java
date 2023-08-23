package org.streamapi;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Stream APi!");
        filterDemo();

    }

    protected static void filterDemo()
    {
        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        System.out.println(stream.toString());
        System.out.println(anyElement.toString());

    }


}