package JavaDrills;

import java.util.ArrayList;
import java.util.List;

public class MoveZerosV2 {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(0, 1, 0, 3, 12));
        moveZerosToEnd(a);
        System.out.println(a);   // [1, 3, 12, 0, 0]

        List<Integer> b = new ArrayList<>(List.of(0, 0, 0));
        moveZerosToEnd(b);
        System.out.println(b);   // [0, 0, 0]

        List<Integer> c = new ArrayList<>(List.of(1, 2, 3));
        moveZerosToEnd(c);
        System.out.println(c);   // [1, 2, 3]

        List<Integer> d = new ArrayList<>();
        moveZerosToEnd(d);
        System.out.println(d);   // []
    }

    public static void moveZerosToEnd(List<Integer> nums) {
        int insertPos = 0;
        int sizeOfList = nums.size();

        for (int i = 0; i < sizeOfList; i++) {
            if (nums.get(i) != 0) {
                nums.set(insertPos, nums.get(i));
                insertPos++;
            }
        }

        for (int i = insertPos; i < sizeOfList; i++) {
            nums.set(i, 0);
        }

    }
}