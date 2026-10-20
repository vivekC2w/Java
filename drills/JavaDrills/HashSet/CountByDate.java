package JavaDrills.Sorting;

import java.util.*;

public class CountByDate {

    // Count events per date, returned EARLIEST DATE FIRST.
    public static Map<String, Integer> countByDateSorted(List<String> dates) {
        Map<String, Integer> cntMapByDateSorted = new TreeMap<>();

        for (String date : dates) {
            cntMapByDateSorted.put(date, cntMapByDateSorted.getOrDefault(date, 0) + 1);
        }

        return cntMapByDateSorted;
    }

    // countByDateSorted — O(n log n) time: TreeMap pays O(log n) per put to keep keys sorted

    // Count events per date, returned in the order each date was FIRST SEEN.
    public static Map<String, Integer> countByDateSeen(List<String> dates) {
        Map<String, Integer> cntMapByDateInserted = new LinkedHashMap<>();

        for (String date : dates) {
            cntMapByDateInserted.put(date, cntMapByDateInserted.getOrDefault(date, 0) + 1);
        }

        return cntMapByDateInserted;
    }

    // countByDateSeen   — O(n) time: LinkedHashMap is a HashMap plus a linked list, O(1) per put

    public static void main(String[] args) {
        List<String> input = List.of(
                "2026-10-15", "2026-10-14", "2026-10-15", "2026-10-13", "2026-10-14");

        System.out.println(countByDateSorted(input));
        // {2026-10-13=1, 2026-10-14=2, 2026-10-15=2}

        System.out.println(countByDateSeen(input));
        // {2026-10-15=2, 2026-10-14=2, 2026-10-13=1}

        System.out.println(countByDateSorted(List.of()));   // {}
        System.out.println(countByDateSeen(List.of()));     // {}
    }
}

// both O(k) space, k = distinct dates

