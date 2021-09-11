package no151_reverseWords;

import java.util.Arrays;
import java.util.Collections;
public class Solution2 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
