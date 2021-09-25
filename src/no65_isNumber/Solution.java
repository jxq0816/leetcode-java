package no65_isNumber;

public class Solution {
    public boolean isNumber(String s) {
        if("e".equals(s)||".".equals(s)||"+.".equals(s)||"-.".equals(s)){
            return false;
        }
        boolean b0=s.matches("(\\+|-){0,1}[0-9]+(\\.)(e|E)(\\+|-)?[0-9]+");//科学计数有小数点1.e2,小数点和e相邻
        boolean b1=s.matches("(\\+|-){0,1}[0-9]*(\\.)[0-9]+(e|E)(\\+|-)?[0-9]+");//科学计数有小数点53.5e93,小数点和e中间有整数
        boolean b2=s.matches("(\\+|-){0,1}[0-9]+((e|E)(\\+|-)?[0-9]+)|([0-9]+)*");//科学计数无小数点
        boolean b3=s.matches("(\\+|-){0,1}[0-9]*(\\.)?[0-9]*");//无科学计数
        return b0||b1||b2||b3;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isNumber("6+1"));
        String[] list={"+.","-01","6+1",".1",".","e","e9",".e1","2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for(String s:list){
            System.out.println(s+":"+solution.isNumber(s));
        }
    }
}