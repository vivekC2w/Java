package JavaDrills.Sorting;

import java.util.*;

public class TopThreeWordsV2 {

    // Return the 3 most frequent words, most frequent first.
    // Ties broken alphabetically. Fewer than 3 distinct words, return all of them.
    public static List<String> topThree(List<String> words) {
        //need to create new hashmap where we can map the "string" with cnt of their occurance
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =new ArrayList<>(freqMap.entrySet());

        list.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());

            if(byCount != 0) return byCount;
            return a.getKey().compareTo(b.getKey());
        });

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < Math.min(3, list.size()); i++) {
            resultList.add(list.get(i).getKey());
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(topThree(List.of("a","b","a","c","b","a")));          // [a, b, c]
        System.out.println(topThree(List.of("x","y","z","x","y","z","w")));      // [x, y, z]
        System.out.println(topThree(List.of("b","a","b","a","c","c")));          // [a, b, c]
        System.out.println(topThree(List.of("one","two")));                      // [one, two]
        System.out.println(topThree(List.of()));                                 // []
    }
}

//O(n + k log k) time complexity
//0(K) space complexity