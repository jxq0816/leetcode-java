package no39_combination_sum;


/*
* 以最小的金币个数，组成指定金额
* */

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static List rs=new ArrayList();
    public static List list=new ArrayList();

    public List lessCoins(int[] a,int target){
        dfs(a,target,0);
        return rs;
    }

    public void dfs(int[] a,int target,int index){
        if(index==a.length){
            return;
        }
        if(target==0){
            rs.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(a,target,index+1);
        if(target>=a[index]){
            list.add(a[index]);
            dfs(a,target-a[index],index);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a={1,5,10,20,50};
        int target=80;
        Solution2 solution2=new Solution2();
        List rs=solution2.lessCoins(a,target);
        System.out.println(rs);
    }
}
