package JavaDrills.Deque;

import java.util.*;
import java.util.stream.Collectors;

public class TopK {

    // Return the k largest numbers, largest first.
    public static List<Integer> topK(List<Integer> nums, int k) {
        List<Integer> firstKSortedList = new ArrayList<>(nums);

        if(firstKSortedList.isEmpty()) return new ArrayList<>();

        firstKSortedList.sort(Comparator.reverseOrder());

        int limit = Math.min(k, firstKSortedList.size());

        return new ArrayList<>(firstKSortedList.subList(0, limit));
    }

    //time complexity O(n log (n)) for sorting and if we use new sortedList for sorting then space complxity will be o(m) where m will size of list

    public static List<Integer> topKFast(List<Integer> nums, int k) {
        if (k <= 0) return new ArrayList<>();

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (Integer num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> result = new ArrayList<>(heap);

        result.sort(Comparator.reverseOrder());

        return result;
    }

//   time complexity -> O(n log k) and space complexity O(k)

    public static void main(String[] args) {
        System.out.println(topKFast(List.of(5, 1, 9, 3, 7), 2));   // [9, 7]
        System.out.println(topKFast(List.of(5, 1, 9, 3, 7), 5));   // [9, 7, 5, 3, 1]
        System.out.println(topKFast(List.of(5, 1, 9, 3, 7), 0));   // []
        System.out.println(topKFast(List.of(3), 5));               // [3]
        System.out.println(topKFast(List.of(), 3));                // []
    }
}