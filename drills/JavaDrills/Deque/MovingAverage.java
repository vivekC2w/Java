package JavaDrills.Deque;

import java.util.*;

public class MovingAverage {

    private final int size;
    private final Deque<Integer> window;
    private double sum = 0;

    // Keeps a window of the last `size` numbers.
    public MovingAverage(int size) {
        this.size = size;
        this.window = new ArrayDeque<>();
    }

    // Adds val to the window and returns the average of the window's current contents.
    public double next(int val) {
        this.window.offer(val);
        sum += val;
        if (this.window.size() > this.size) {
            sum = sum - this.window.pollFirst();
        }
        return sum / this.window.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));    // 1.0
        System.out.println(m.next(10));   // 5.5
        System.out.println(m.next(3));    // 4.666666666666667
        System.out.println(m.next(5));    // 6.0
        System.out.println(m.next(5));    // 4.333333333333333
    }
}

// next(): O(1) — one add, at most one remove, one division.
//         Without the running sum it would be O(size), re-adding the window every call.
// space:  O(size)