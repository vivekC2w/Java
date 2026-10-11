package JavaDrills;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        test("swiss");      // w
        test("aabbc");      // c
        test("a");          // a
        test("aabbcdc");    // d
        test("aabbcc");     // no answer
        test("");           // no answer
    }

    private static void test(String text) {
        try {
            System.out.println("\"" + text + "\" -> " + firstNonRepeating(text));
        } catch (RuntimeException e) {
            System.out.println("\"" + text + "\" -> " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
        }
    }

    public static char firstNonRepeating(String text) {
        int len = text.length();
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0)+ 1);
        }

        for (Map.Entry<Character, Integer> map : charMap.entrySet()) {
            if(map.getValue() == 1) {
                return map.getKey();
            }
        }
        throw new IllegalArgumentException("No non-repeating character in: " + text);
    }
}