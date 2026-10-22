package JavaDrills.Debugging;

import java.util.*;

public class SameActivity {

    // Given a map of user -> login count, return everyone who has exactly
    // the same login count as the given user (excluding the user themselves).
    public static List<String> sameLoginCount(Map<String, Integer> logins, String user) {
        List<String> result = new ArrayList<>();
        Integer target = logins.get(user);

        for (Map.Entry<String, Integer> entry : logins.entrySet()) {
            if (entry.getKey().equals(user)) continue;
            if (entry.getValue().equals(target)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> quiet = new LinkedHashMap<>();
        quiet.put("amit", 12);
        quiet.put("riya", 12);
        quiet.put("zoya", 7);
        System.out.println(sameLoginCount(quiet, "amit"));   // expected [riya]

        Map<String, Integer> busy = new LinkedHashMap<>();
        busy.put("amit", 340);
        busy.put("riya", 340);
        busy.put("zoya", 95);
        System.out.println(sameLoginCount(busy, "amit"));    // expected [riya]
    }
}