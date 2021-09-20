package no6_zig_zag_conversion;

public class Solution {
    public String convert(String s,int numRows){
        if(s.isEmpty()||numRows==1){
            return s;
        }
        StringBuilder[] array=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            array[i]=new StringBuilder();
        }
        int dir=1;
        int index=0;
        for(char c :s.toCharArray()){
            array[index].append(c);
            index+=dir;
            if(index==0 || index==numRows-1){
                dir=-dir;
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<array.length;i++){
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String rs=solution.convert("LEETCODEISHIRING",3);
        System.out.println(rs);
    }
}
