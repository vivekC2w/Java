package JavaDrills;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, String> capitals = new LinkedHashMap<>();
        capitals.put("India", "Delhi");
        capitals.put("France", "Paris");
        capitals.put("Japan", "Tokyo");
        System.out.println(invert(capitals));
        // {Delhi=India, Paris=France, Tokyo=Japan}

//        Map<String, String> dupes = new HashMap<>();
//        dupes.put("a", "x");
//        dupes.put("b", "x");
//        System.out.println(invert(dupes));
        // ?  <- you decide

        System.out.println(invert(new HashMap<>()));
        // {}
    }

    public static Map<String, String> invert(Map<String, String> source) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : source.entrySet()) {
            if (resultMap.containsKey(entry.getValue())) {
                throw new IllegalArgumentException("Duplicate value: " + entry.getValue());
            }
            resultMap.put(entry.getValue(), entry.getKey());
        }
        return resultMap;
    }
}