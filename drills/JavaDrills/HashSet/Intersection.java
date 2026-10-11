package JavaDrills;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        System.out.println(intersection(
                new ArrayList<>(List.of("apple", "banana", "cherry")),
                new ArrayList<>(List.of("banana", "cherry", "date"))));
        // [banana, cherry]

        System.out.println(intersection(
                new ArrayList<>(List.of("a", "b", "c")),
                new ArrayList<>(List.of("x", "y"))));
        // []

        System.out.println(intersection(
                new ArrayList<>(List.of("a", "a", "b")),
                new ArrayList<>(List.of("a", "b"))));
        // ?  <- you decide

        System.out.println(intersection(
                new ArrayList<String>(),
                new ArrayList<>(List.of("a"))));
        // []
    }

    public static List<String> intersection(List<String> a, List<String> b) {
        Set<String> bSet = new HashSet<>(b);
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String item : a) {
            if(bSet.contains(item)) {
                if(seen.add(item)) result.add(item);
            }
        }

        return result;

        //Time complexity -> O(n) and space complixty -> O(n) where n is a number of common elements in both list
    }
}