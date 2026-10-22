package JavaDrills.HashSet;

import java.util.*;

public class FirstDuplicateV2 {

    // Return the first duplicated element — scanning left to right,
    // the first one you've already seen. Null if there's no duplicate.
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
    }

    //Time complexity O(N^2) and space complexity O(1)

    public static String firstDuplicateFast(List<String> items) {
        Set<String> seen = new HashSet<>();

        for (String item : items) {
            if (!seen.add(item)) return item;
        }
        return null;
    }

//    Time complexity O(N) and space complexity O(N)

    public static void main(String[] args) {
        System.out.println(firstDuplicate(List.of("a","b","c","a","b")));      // a
        System.out.println(firstDuplicateFast(List.of("a","b","c","a","b")));  // a

        System.out.println(firstDuplicate(List.of("a","b","b","a")));          // b
        System.out.println(firstDuplicateFast(List.of("a","b","b","a")));      // b

        System.out.println(firstDuplicate(List.of("a","b","c")));              // null
        System.out.println(firstDuplicateFast(List.of("a","b","c")));          // null

        System.out.println(firstDuplicate(List.of()));                         // null
        System.out.println(firstDuplicateFast(List.of()));                     // null

        System.out.println(firstDuplicate(List.of("x","x")));                  // x
        System.out.println(firstDuplicateFast(List.of("x","x")));              // x
    }
}