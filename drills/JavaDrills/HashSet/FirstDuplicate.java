package JavaDrills.HashSet;

import java.util.*;

public class FirstDuplicate {

    // Return the first duplicated element in the list.
    public static String firstDuplicate(List<String> items) {
        int len = items.size();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(items.get(i).equals(items.get(j))) {
                    return items.get(i);
                }
            }
        }
        return null;
//        Time Complexity -> O(n^2) and space complexity -> O(1)
    }

    public static String firstDuplicateV2(List<String> items) {
        Set<String> seen = new HashSet<>();

        for (String item : items) {
            if (!seen.add(item)) return item;
        }
        return null;
        //Time complexity O(n) and space complexity O(n)
    }

    public static void main(String[] args) {
        System.out.println(firstDuplicateV2(List.of("a", "b", "c", "a", "b")));  // expect ?
        System.out.println(firstDuplicateV2(List.of("a", "b", "b", "a")));       // expect ?  <- think
        System.out.println(firstDuplicateV2(List.of("a", "b", "c")));            // expect ?
        System.out.println(firstDuplicateV2(List.of()));                         // expect ?
        System.out.println(firstDuplicateV2(List.of("x", "x")));                 // expect ?
        System.out.println(firstDuplicate(List.of("a","b","b","a")) + " / " + firstDuplicateV2(List.of("a","b","b","a")));  // b / b
    }
}