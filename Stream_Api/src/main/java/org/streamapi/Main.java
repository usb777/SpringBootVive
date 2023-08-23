package org.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    protected static void collectDemo()
    {
        List number = Arrays.asList(2,3,4,5);
        List square = number.stream().map(x->multiply(x)).collect(Collectors.toList());

    }
     private static int multiply(Integer a)
     {return a*a;}


}