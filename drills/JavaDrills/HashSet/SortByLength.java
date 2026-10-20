package JavaDrills.Sorting;

import java.util.*;

public class SortByLength {

    // Return a NEW list sorted by string length, shortest first.
    // Ties broken alphabetically. The input list must not be modified.
    public static List<String> sortByLength(List<String> words) {
        List<String> sortedList = new ArrayList<>(words);

        sortedList.sort((a, b) -> {
            int byLength = Integer.compare(a.length(), b.length());
            if (byLength != 0) return byLength;
            return a.compareTo(b);
        });
        return sortedList;
    }

//    O(n log n) time, O(n) space for both

    public static List<String> sortByLengthV2(List<String> words) {
        List<String> sortedList = new ArrayList<>(words);
        sortedList.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        return sortedList;
    }

    public static void main(String[] args) {
        List<String> input = List.of("banana", "kiwi", "apple", "fig", "date");
        System.out.println(sortByLengthV2(input));                              // [fig, date, kiwi, apple, banana]
        System.out.println(input);                                            // [banana, kiwi, apple, fig, date]  <- unchanged
        System.out.println(sortByLengthV2(List.of("bb", "aa", "cc")));          // [aa, bb, cc]
        System.out.println(sortByLengthV2(List.of()));                          // []
        System.out.println(sortByLengthV2(List.of("a")));                       // [a]
    }
}