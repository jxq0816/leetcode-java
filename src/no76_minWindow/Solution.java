package no76_minWindow;

public class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n>m){
            return "";
        }
        String rs="";
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                String sub=s.substring(i,j+1);
                if(check(sub,t)){
                    if(rs=="" || sub.length()<rs.length()){
                        rs=sub;
                    }
                }
            }
        }
        return rs;
    }
    public boolean check(String sub,String t){
        boolean bool=false;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!sub.contains(String.valueOf(ch))){
                return false;
            }else{
                sub=sub.replaceFirst(String.valueOf(ch),"");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a="a";
        String t="a";
        Solution solution=new Solution();
        System.out.println(solution.minWindow(a,t));
    }
}
