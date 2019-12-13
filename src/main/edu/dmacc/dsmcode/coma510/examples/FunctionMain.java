package edu.dmacc.dsmcode.coma510.examples;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
//        Function<String, String> greet = (String name) -> "Hello " + name + "!";
        Function<String, String> greet = name -> "Hello " + name + "!";
        System.out.println(greet.apply("Greg"));

//        Function<String, Void> printGreeting = name -> {
//            System.out.println("Hello " + name + "!");
//            return null;
//        };
//        printGreeting.apply("Greg");
        Consumer<String> printGreeting = name -> System.out.println("Hello " + name + "!");
        printGreeting.accept("Greg");

        BiConsumer<String, String> printCustomGreeting =
                (name, greeting) -> System.out.println(greeting + " " + name + "!");
        printCustomGreeting.accept("Greg", "Welcome");

        // Functions also works with other types
        BiFunction<Integer, Integer, String> sumString =
                (Integer a, Integer b) -> "" + (a + b);
        System.out.println("1 + 2 = " + sumString.apply(1, 2));

        System.out.println("1 + 2 = " + calculate(1, 2, sumString));
        System.out.println("1 * 2 = " + calculate(1, 2, (Integer a, Integer b) -> "" + (a * b)));
    }

    public static String calculate(
            int a, int b, BiFunction<Integer, Integer, String> calculation) {
        return calculation.apply(a, b);
    }
}
