package JavaDrills.Deque;

import java.util.*;

public class BalancedBrackets {

    // True if every opening bracket has a matching closing bracket, correctly nested.
    // Brackets are ( ) [ ] { }. Other characters are ignored.
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if ((c == ')' && top == '(') ||
                        (c == '}' && top == '{') ||
                        (c == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("(a[b]{c})"));   // true
        System.out.println(isBalanced("([)]"));        // false
        System.out.println(isBalanced("((("));         // false
        System.out.println(isBalanced(")("));          // false
        System.out.println(isBalanced("a + b"));       // true
        System.out.println(isBalanced(""));            // true
    }
}

//time complexity will be O(N) and space complexity will be O(N) where n is number of character in string