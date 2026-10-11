package JavaDrills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllUnique {

//     Return true if every character in s appears exactly once.
    public static boolean allUnique(String s) {
        String str = s.toLowerCase();
        //brute force I'm thing is sort them alphabetically and then traverse through it
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) {
                return false;
            }
        }
        return true;

//        Time complexity -> O(nlogn) + O(n) and SPace complexity -> O(n)
    }

    public static boolean allUniqueFast(String s) {
        char[] charArr = s.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for(char ch : charArr) {
            charSet.add(ch);
        }
        return charArr.length == charSet.size();
        //time and space complexity -> O(n)
    }

    public static void main(String[] args) {
        System.out.println(allUniqueFast("abcde"));      // expect true
        System.out.println(allUniqueFast("hello"));      // expect false
        System.out.println(allUniqueFast(""));           // expect ?  <- you decide
        System.out.println(allUniqueFast("a"));          // expect true
        System.out.println(allUnique("aA"));         // expect ?  <- you decide
        System.out.println(allUnique("ab ba"));      // expect false
    }
}