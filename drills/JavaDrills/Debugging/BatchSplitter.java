package JavaDrills.Debugging;

import java.util.*;

public class BatchSplitter {

    // Split items into batches of at most maxSize, preserving order.
    public static List<List<String>> batch(List<String> items, int maxSize) {
        List<List<String>> batches = new ArrayList<>();
        List<String> current = new ArrayList<>();

        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be positive, was " + maxSize);
        }

        for (int i = 0; i < items.size(); i++) {
            current.add(items.get(i));
            if (current.size() == maxSize) {
                batches.add(current);
                current = new ArrayList<>();
            }
        }
        if(current.size() > 0) batches.add(current);
        return batches;
    }

    public static void main(String[] args) {
        System.out.println(batch(List.of("a","b","c","d","e"), 2));   // [[a, b], [c, d], [e]]
        System.out.println(batch(List.of("a","b","c","d"), 2));       // [[a, b], [c, d]]
        System.out.println(batch(List.of(), 2));                      // []
        System.out.println(batch(List.of("a"), 3));                   // [[a]]
        System.out.println(batch(List.of("a","b","c"), 1));           // [[a], [b], [c]]
    }
}
