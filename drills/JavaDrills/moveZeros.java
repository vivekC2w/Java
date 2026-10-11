package JavaDrills;

/*
 * 1. Restate: Move zeros to the end
 * 2. Examples + edge cases:
 * [0, 1, 0, 3, 12] → [1, 3, 12, 0, 0] In place. Non-zero order preserved.
 * Edge cases worth listing: all zeros, no zeros, empty list.
 * 3. Brute force + complexity:
 * brute force: create a new array, iterate through the original array and add non-zero elements to the new array,
 * then add zeros to the end of the new array.
 * 4. Why not good enough: But this uses extra space. Complexity: O(n) time, O(n) space.
 * 5. My approach:
 * 6. Complexity:
 */

import java.util.ArrayList;
import java.util.List;

public class moveZeros {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(0, 1, 0, 3, 12));
        moveZerosToEnd(nums);
        System.out.println(nums);          // [1, 3, 12, 0, 0]

        List<Integer> allZeros = new ArrayList<>(List.of(0, 0, 0));
        moveZerosToEnd(allZeros);
        System.out.println(allZeros);      // [0, 0, 0]

        List<Integer> noZeros = new ArrayList<>(List.of(1, 2, 3));
        moveZerosToEnd(noZeros);
        System.out.println(noZeros);       // [1, 2, 3]

        List<Integer> empty = new ArrayList<>();
        moveZerosToEnd(empty);
        System.out.println(empty);
    }

    public static void moveZerosToEnd(List<Integer> nums) {
        int insertPos = 0;
        int sizeOfList = nums.size();

        for(int i = 0; i < sizeOfList; i++) {
            if(nums.get(i) != 0) {
                nums.set(insertPos, nums.get(i));
                insertPos++;
            }
        }
        for(int i = insertPos; i < sizeOfList; i++) {
            nums.set(i, 0);
        }
    }
}
