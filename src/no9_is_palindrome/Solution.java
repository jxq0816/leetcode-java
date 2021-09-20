package no9_is_palindrome;

import java.util.Stack;
public class Solution {
    public boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        int j=0;
        while(!stack.isEmpty()){
            if(stack.pop()!=s.charAt(j++)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isPalindrome(10));
    }
}
