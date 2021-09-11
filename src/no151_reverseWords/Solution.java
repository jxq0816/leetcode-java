package no151_reverseWords;

import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String rs="";
        Stack stack=new Stack<String>();
        String[] array=s.split(" ");
        for(String word : array){
            word=word.trim();
            if(!word.isEmpty()){
                stack.push(word);
            }
        }
        while(!stack.isEmpty()){
            rs+=stack.pop();
            rs+=" ";
        }
        return rs.trim();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}
