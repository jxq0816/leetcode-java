package no14_longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int min=Integer.MAX_VALUE;
        for(String str: strs){
            min=str.length()<min?str.length():min;
        }
        String rs="";
        for(int i=1;i<=min;i++){
            String sub=strs[0].substring(0,i);
            Boolean bool=true;
            for(String str: strs){
                if(!str.startsWith(sub)){
                    bool=false;
                    break;
                }
            }
            if(bool){
                rs=sub;
            }else{
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] strs=new String[]{"flower","flow","flight"};
        String rs=solution.longestCommonPrefix(strs);
        System.out.println(rs);
    }
}
