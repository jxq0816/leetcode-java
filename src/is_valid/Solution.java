package is_valid;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<len;i++){
            stack.push(s.charAt(i));
        }
        Stack<Character> stack2=new Stack<Character>();
        while(!stack.isEmpty()){
            Character ch=stack.pop();
            Character peek=' ';
            if(!stack2.isEmpty()){
                peek=stack2.peek();
            }
            if(ch=='(' && peek==')'){
                stack2.pop();
                continue;
            }
            if(ch=='{' && peek=='}'){
                stack2.pop();
                continue;
            }
            if(ch=='[' && ']'==peek){
                stack2.pop();
                continue;
            }
            stack2.push(ch);
        }
        if(stack2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValid("["));
    }
}
