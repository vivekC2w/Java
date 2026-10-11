package JavaDrills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        test(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 2);   // [4, 5, 1, 2, 3]
        test(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 1);   // [5, 1, 2, 3, 4]
        test(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 5);   // [1, 2, 3, 4, 5]
        test(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 7);   // [4, 5, 1, 2, 3]
        test(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 0);   // [1, 2, 3, 4, 5]
        test(new ArrayList<>(List.of(1)), 1);               // [1]
        test(new ArrayList<Integer>(), 3);                  // []
    }

    private static void test(List<Integer> nums, int k) {
        rotate(nums, k);
        System.out.println("k=" + k + " -> " + nums);
    }

    public static void rotate(List<Integer> nums, int k) {
        int sizeOfList = nums.size();
        if (sizeOfList == 0) return;
        k = k % sizeOfList;

        Collections.reverse(nums);
        Collections.reverse(nums.subList(0, k));
        Collections.reverse(nums.subList(k, sizeOfList));
    }

    private static void reverse(List<Integer> nums, int start, int end) {
        // your Tuesday code, but with start and end passed in
        // instead of 0 and size-1
        while ( start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}