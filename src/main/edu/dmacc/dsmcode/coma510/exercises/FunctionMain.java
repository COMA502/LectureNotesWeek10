package edu.dmacc.dsmcode.coma510.exercises;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class FunctionMain {
    public static void main(String[] args) {
        HashMap<String, Integer> agesByName = new HashMap<>();
        agesByName.put("Alex", 47);
        agesByName.put("Bob", 30);
        agesByName.put("Carry", 10);
        agesByName.put("Deb", 23);

//        BiFunction<String, Integer, String> format =
//                (String name, Integer age) -> name + " is " + age;
        BiFunction<String, Integer, String> format =
                (String name, Integer age) -> {
                    return name + " is " + age;
                };
        BiConsumer<String, Integer> formatAndPrint =
                (String name, Integer age) -> System.out.println(name + " is " + age);

        System.out.println("Using BiFunction:");
        printEachPerson(agesByName, format);
        System.out.println("\nUsing BiConsumer:");
        printEachPerson(agesByName, formatAndPrint);

        // Alternatively do it all in one line!
        agesByName.forEach((String name, Integer age) -> System.out.println(name + " is " + age));
    }

    public static void printEachPerson(
            HashMap<String, Integer> people, BiFunction<String, Integer, String> format) {
        for(String name : people.keySet()) {
            System.out.println(format.apply(name, people.get(name)));
        }
    }

    public static void printEachPerson(
            HashMap<String, Integer> agesByName, BiConsumer<String, Integer> formatAndPrint) {
        agesByName.forEach(formatAndPrint);
//        for(String name : agesByName.keySet()) {
//            formatAndPrint.accept(name, agesByName.get(name));
//        }
    }
}
