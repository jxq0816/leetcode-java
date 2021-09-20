package no13_roman2int;

public class Solution {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        int rs=0;
        for(int i=0;i<array.length;i++){
            char current=array[i];
            char next = 0;
            if(i<array.length-1){
                next=array[i+1];
            }
            if(current=='I' && next=='V'){
                rs+=4;
                i=i+1;
                continue;
            }
            if(current=='I' && next=='X'){
                rs+=9;
                i=i+1;
                continue;
            }
            if(current=='X' && next=='L'){
                rs+=40;
                i=i+1;
                continue;
            }
            if(current=='X' && next=='C'){
                rs+=90;
                i=i+1;
                continue;
            }
            if(current=='C' && next=='D'){
                rs+=400;
                i=i+1;
                continue;
            }
            if(current=='C' && next=='M'){
                rs+=900;
                i=i+1;
                continue;
            }
            if(current=='I'){
                rs+=1;
            }
            if(current=='V'){
                rs+=5;
            }
            if(current=='X'){
                rs+=10;
            }
            if(current=='L'){
                rs+=50;
            }
            if(current=='C'){
                rs+=100;
            }
            if(current=='D'){
                rs+=500;
            }
            if(current=='M'){
                rs+=1000;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int rs=solution.romanToInt("MCMXCIV");
        System.out.println(rs);
    }
}
