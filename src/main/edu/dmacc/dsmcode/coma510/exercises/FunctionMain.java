package edu.dmacc.dsmcode.coma510.exercises;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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


//        Change your code to use the Map's enrtySet().stream() method
//        Filter out all people less than 25
//        Sort the names by age
//        Use the terminal operator forEach to print the name and age like before
        System.out.println("\nFiltering and Sorting:");
        agesByName.entrySet().stream()
                .filter(person -> person.getValue() >= 25)
//                .sorted((personA, personB) -> Integer.compare(personA.getValue(), personB.getValue()))
                .sorted(Comparator.comparingInt(Map.Entry::getValue)) // FunctionalInterface suggested by IntelliJ
                .forEach(person -> formatAndPrint.accept(person.getKey(), person.getValue()));
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
