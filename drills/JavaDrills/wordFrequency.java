package JavaDrills;

import java.util.HashMap;
import java.util.Map;

public class wordFrequency {
    public static void main(String[] args) {
        System.out.println(wordFrequency("the quick brown fox the lazy fox the dog"));

        System.out.println(wordFrequency("hello"));
    }

    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> result = new HashMap<>();
        text = text.toLowerCase();
        String[] words = text.split("\\s+");
//        String[] words = text.toLowerCase().split("\\s+");

        for(String str : words) {
            result.put(str, result.getOrDefault(str, 0) + 1 );
        }
        System.out.println("result");
        return result;
    }
}
