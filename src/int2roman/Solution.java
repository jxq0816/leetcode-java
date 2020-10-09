package int2roman;

public class Solution {
    public String intToRoman(int num) {
        int n1=num/1000;
        int n2=(num%1000)/500;
        int n3=((num%1000)%100)/50;
        int n4=(((num%1000)%100)%50)/10;
        int n5=((((num%1000)%100)%50)%10)/5;
        int n6=((((num%1000)%100)%50)%10)%5;
        String rs="";
        while(n1>0){
            rs=rs+"M";
            n1--;
        }
        while(n2>0){
            rs=rs+"M";
            n1--;
        }
        System.out.print(rs);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String rs=solution.intToRoman(1994);
    }
}
