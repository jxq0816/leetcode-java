package no8_atoi;
//8. 字符串转换整数 (atoi)
import java.math.BigInteger;
import java.util.regex.Pattern;
public class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty()) {
            return 0;
        }
        str=str.trim();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d].*$");
        if(!pattern.matcher(str).matches()){
            return 0;
        }
        String rs="";
        String signal="";
        char[] array=str.toCharArray();
        int i=0;
        if(array[0]=='-'||array[0]=='+'){
            signal=String.valueOf(array[0]);
            i++;
        }
        for(;i<array.length;i++){
            if(array[i]>='0' && array[i]<='9'){
                rs+=array[i];
            }else{
                break;
            }
        }
        rs=signal+rs;
        BigInteger bigInteger=new BigInteger(rs);

        if(bigInteger.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        if(bigInteger.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        return new Integer(rs);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.myAtoi("20000000000000000000"));
        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("3.14"));
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }
}
