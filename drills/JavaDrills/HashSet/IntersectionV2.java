package JavaDrills.HashSet;

import java.util.*;

public class IntersectionV2 {

    // Return elements present in BOTH lists, in the order they appear in a, no duplicates.
    public static List<String> intersection(List<String> a, List<String> b) {
        // brute force
        List<String> intersectedList = new ArrayList<>();

        for (String x : a) {
            if(b.contains(x) && !intersectedList.contains(x)) intersectedList.add(x);
        }

        return intersectedList;
    }

    public static List<String> intersectionFast(List<String> a, List<String> b) {
        // set version
        Set<String> bSet = new HashSet<>(b);
        Set<String> seen = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (String x : a) {
            if(bSet.contains(x)) {
                if(seen.add(x)) list.add(x);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(intersection(List.of("a","b","c","a"), List.of("c","a","d")));      // [a, c]
        System.out.println(intersectionFast(List.of("a","b","c","a"), List.of("c","a","d")));  // [a, c]

        System.out.println(intersection(List.of("a","b"), List.of("c","d")));                  // []
        System.out.println(intersectionFast(List.of("a","b"), List.of("c","d")));              // []

        System.out.println(intersection(List.of(), List.of("a")));                             // []
        System.out.println(intersectionFast(List.of(), List.of("a")));                         // []

        System.out.println(intersection(List.of("x","x","y"), List.of("x","y")));              // [x, y]
        System.out.println(intersectionFast(List.of("x","x","y"), List.of("x","y")));          // [x, y]

        System.out.println(intersectionFast(
                List.of("banana","apple","cherry"), List.of("cherry","apple","banana")));
    }
}

// intersection      — O(n·m) time: List.contains is a linear scan, once per element of a
// intersectionFast  — O(n+m) time: O(m) to build bSet, then O(1) lookups
//                     space: O(m) for bSet, O(k) for seen and the result, k = distinct common elements