package JavaDrills.Sorting;

import java.util.*;

public class TopSpenders {

    public static List<String> topSpenders(List<String> transactions) {

        //check if list is empty
        if (transactions.isEmpty()) return new ArrayList<>();

        //declare new map to store the list in key value pair and split by delimiter :
        Map<String, Integer> transMap = new HashMap<>();

        //we will convert the input list into map as we need unique keys
        for (String transaction : transactions) {
            String[] parts = transaction.split(":");

            String name = parts[0];
            int amount = Integer.parseInt(parts[1]);

            transMap.put(name, transMap.getOrDefault(name, 0) + amount);
        }

        //here we cannot sort map directly so we need to convert that map into list

        //Declare new entries list
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(transMap.entrySet());

        entries.sort((a, b) -> {
            int byValue = b.getValue().compareTo(a.getValue());
            if(byValue != 0) return byValue;

            return a.getKey().compareTo(b.getKey());
        });
        
        //need to return list of string so create new result list
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entries) {
            result.add(entry.getKey());
        }

        return result;
    }

    // Time complexity: O(n + k log k)
    // Space complexity: O(k)

    public static void main(String[] args) {
        System.out.println(topSpenders(List.of(
                "amit:100", "riya:250", "amit:200", "zoya:250"
        )));                                              // [amit, riya, zoya]

        System.out.println(topSpenders(List.of(
                "bob:50", "alice:50", "carol:10"
        )));                                              // [alice, bob, carol]

        System.out.println(topSpenders(List.of("solo:7"))); // [solo]

        System.out.println(topSpenders(List.of()));         // []
    }
}