package JavaDrills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByFirstLetter {
    public static void main(String[] args) {
        System.out.println(groupByFirstLetter(new ArrayList<>(
                List.of("apple", "avocado", "banana", "blueberry", "cherry"))));
        // {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}

        System.out.println(groupByFirstLetter(new ArrayList<>(
                List.of("dog"))));
        // {d=[dog]}

        System.out.println(groupByFirstLetter(new ArrayList<String>()));
        // {}
    }

    public static Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        //I want to convert this list into array of strings
        String[] wordsArr = words.toArray(String[]::new);
        Map<Character, List<String>> result = new HashMap<>();

        for (String word : wordsArr) {
            char firstChar = word.charAt(0);
            //treverse through whole list and check the words starting with firstChar if we find the words then
            //add to the list with key = firstChar & value = [List of words starting with that char]
            result.computeIfAbsent(firstChar, key -> new ArrayList<>()).add(word);
        }
        return result;
    }
}