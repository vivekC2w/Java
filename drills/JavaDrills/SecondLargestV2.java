package JavaDrills;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestV2 {
    public static void main(String[] args) {
        System.out.println(secondLargest(new ArrayList<>(List.of(3, 17, 4, 9, 22, 1))));  // 17
        System.out.println(secondLargest(new ArrayList<>(List.of(3, 22, 17))));           // 17
        System.out.println(secondLargest(new ArrayList<>(List.of(1, 2, 3, 4, 5))));       // 4
        System.out.println(secondLargest(new ArrayList<>(List.of(5, 5, 3))));             // 3
        System.out.println(secondLargest(new ArrayList<>(List.of(-10, -3, -7))));         // -7
    }

    public static int secondLargest(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("Need at least two elements");
        }

        int max = nums.get(0);
        int secondMax = Integer.MIN_VALUE;
        int sizeOfList = nums.size();
        boolean foundSecondMax = false;

        for(int i = 1; i < sizeOfList; i++) {
            int val = nums.get(i);
            if (val > max) {
                secondMax = max;
                foundSecondMax = true;
                max = val;
            } else if (val != max && (!foundSecondMax || val > secondMax)) {
                secondMax = val;
                foundSecondMax = true;
            }
        }
        if (!foundSecondMax) {
            throw new IllegalArgumentException("No second distinct value");
        }
        return secondMax;
    }
}