package no150_evalRPN;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> sta=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            System.out.println(tokens[i]);
            if(tokens[i].matches("-{0,1}\\d{1,}")==false){
                Integer a=sta.pop();
                System.out.println("a="+a);
                Integer b=sta.pop();
                System.out.println("b="+b);
                if(tokens[i].equals("+")){
                    sta.push(a+b);
                    System.out.println(sta.peek());
                }
                if(tokens[i].equals("-")){
                    sta.push(b-a);
                }
                if(tokens[i].equals("*")){
                    sta.push(a*b);
                }
                if(tokens[i].equals("/")){
                    sta.push(b/a);
                }
            }else{
                sta.push(Integer.parseInt(tokens[i]));
            }
        }
        return sta.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        Solution solution=new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}
