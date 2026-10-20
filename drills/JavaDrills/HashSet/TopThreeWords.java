package JavaDrills.Sorting;

import java.util.*;

public class TopThreeWords {

    // Return the 3 most frequent words, most frequent first.
    // Ties broken alphabetically. If fewer than 3 distinct words, return all of them.
    public static List<String> topThree(List<String> words) {
        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
//        System.out.println("Map ->" + map);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((e1, e2) -> {
            int byLength = Integer.compare(e2.getValue(), e1.getValue());
            if (byLength != 0) return  byLength;
            return e1.getKey().compareTo(e2.getKey());
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            result.add(list.get(i).getKey());
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(topThree(List.of("a","b","a","c","b","a")));          // [a, b, c]
        System.out.println(topThree(List.of("x","y","z","x","y","z","w")));      // [x, y, z]
        System.out.println(topThree(List.of("b","a","b","a","c","c")));          // [a, b, c]
        System.out.println(topThree(List.of("one","two")));                      // [one, two]
        System.out.println(topThree(List.of()));                                 // []
    }
}