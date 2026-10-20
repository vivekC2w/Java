package JavaDrills.Debug;

import java.util.*;

public class LatestStatus {

    // Events arrive in chronological order, formatted "carrier:status".
    // Return the LATEST status for each carrier.
    public static Map<String, String> latestStatus(List<String> events) {
        Map<String, String> result = new HashMap<>();
        for (String event : events) {
            String[] parts = event.split(":", 2);
            String carrier = parts[0].trim();
            String status = parts[1].trim();
            result.put(carrier, status);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(latestStatus(List.of(
                "DHL:picked up",
                "Evri:at depot",
                "DHL:delivered"
        )));
        // expect {DHL=delivered, Evri=at depot}

        System.out.println(latestStatus(List.of(
                "Evri:out for delivery: attempt 2"
        )));
        // expect {Evri=out for delivery: attempt 2}
    }
}