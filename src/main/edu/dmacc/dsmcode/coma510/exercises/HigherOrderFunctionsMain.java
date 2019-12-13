package edu.dmacc.dsmcode.coma510.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HigherOrderFunctionsMain {
    /**
     * Create a flattened and sorted list of grades from all classes (e.g. [70, 74, 81, 91, 95, 99]) . Print the list.
     * Use reduce function to get the sum of all grades and size method to get a count. Print the average grade (sum / count).
     */
    public static void main(String[] args) {
        HashMap<String, List<Integer>> gradesByClass = new HashMap<>();
//        gradesByClass.put("Morning Class", Arrays.asList(99, 70, 81));
//        gradesByClass.put("Evening Class", Arrays.asList(95, 91, 74));

        List<Integer> grades = gradesByClass.entrySet().stream()
                .flatMap(classAndGrades -> classAndGrades.getValue().stream())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(grades);

        if(!grades.isEmpty()) {
            Integer sum = grades.stream().reduce(0, (grade, total) -> total + grade);
            System.out.println("Average grade: " + (sum / grades.size()));
        }

        System.out.println("Max Grade: "
                + grades.stream().max(Comparator.naturalOrder()).orElse(100));
        System.out.println("Min Grade: "
                + grades.stream().min(Comparator.naturalOrder()).orElse(0));
    }
}
