package no7_reverse;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class Solution {
    public int reverse(int x) {
        if(x==0){
            return 0;
        }
        Integer i=new Integer(x);
        String str=i.toString();
        String signal="";
        if(str.charAt(0)=='-'){
            signal="-";
            str=str.substring(1,str.length());
        }
        if(str.charAt(str.length()-1)=='0'){
            str=str.substring(0,str.length()-1);
        }
        String rs=signal;
        for(i=str.length()-1;i>=0;i--){
            rs+=str.charAt(i);
        }
        Long rsl=new Long(rs);
        if(rsl>Integer.MAX_VALUE||rsl<Integer.MIN_VALUE){
            return 0;
        }else{
            return new Integer(rs);
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Solution solution=new Solution();
        System.out.println(solution.reverse(-2147483648));
    }
}