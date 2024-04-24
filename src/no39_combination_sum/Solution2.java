package no39_combination_sum;


/*
* 以最小的金币个数，组成指定金额
* */

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List<List<Integer>> rs=new ArrayList<>();
    public static List<Integer> list=new ArrayList<>();
    public static List<List<Integer>> solution(int[] a,int t){
        dfs(a,t,0);
        return rs;
    }
    public static void dfs(int[] a,int t,int i){
        if(i==a.length){
            return;
        }
        if(t==0){
            rs.add(new ArrayList<>(list));
            return;
        }
        dfs(a,t,i+1);
        if(t>=a[i]){
            list.add(a[i]);
            dfs(a,t-a[i],i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a={5,10,20,50};
        Solution2 st=new Solution2();
        List rs=st.solution(a,80);
        System.out.println(rs.toString());
    }
}
