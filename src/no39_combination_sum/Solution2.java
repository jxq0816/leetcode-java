package no39_combination_sum;

import java.util.ArrayList;
import java.util.List;

/*
* 以最小的金币个数，组成指定金额
* */

public class Solution2 {

    public List<List<Integer>> rs=new ArrayList<>();
    public List<Integer> list=new ArrayList<>();

    public List<List<Integer>> solution(int[] a,int target){
        dfs(a,target,0);
        return rs;
    }

    public void dfs(int[] a,int target,int i){
        if(i==a.length){
            return;
        }
        if(target==0){
            rs.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(a,target,i+1);
        if(target>=a[i]){
            list.add(a[i]);
            dfs(a,target-a[i],i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a={5,10,50};
        Solution2 s=new Solution2();
        List<List<Integer>> rs=s.solution(a,80);
        System.out.println(rs.toString());
    }
}
