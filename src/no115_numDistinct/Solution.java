package no115_numDistinct;

public class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        char[] ch=s.toCharArray();
        boolean[] vis=new boolean[n];
        int rs=0;
        dfs(ch,rs,new StringBuffer(),t,0);
        return rs;
    }
    void dfs(char[] canditates, int cnt,StringBuffer str,String t,int index){
        if(index==canditates.length){
            return;
        }
        if(t.equals(str)){
            cnt++;
            return;
        }
        dfs(canditates,cnt,str,t,index+1);//不选
        System.out.println(str);
        if(str.toString()!=t){
            str=str.append(canditates[index]);
            dfs(canditates,cnt,str,t,index+1);//选择
            str=str.deleteCharAt(str.length() - 1);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numDistinct("rabbbit","rabbit"));
    }
}
