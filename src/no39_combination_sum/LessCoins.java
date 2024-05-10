package no39_combination_sum;

import java.util.ArrayList;
import java.util.List;

/*
 * 以最小的金币个数，组成指定金额
 * */

public class LessCoins {
    public static List rs=new ArrayList();
    public static List list=new ArrayList();

    public static List solution(int[] a,int target){
        dfs(a,target,0);
        return rs;
    }

    public static void dfs(int[] a,int target,int i){
        if(i==a.length){
            return;
        }
        if(target==0){
            rs.add(new ArrayList<>(list));
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
        int[] a={5,10,20,50};
        LessCoins lc=new LessCoins();
        List<List<Integer>> rs=lc.solution(a,80);
        int min=Integer.MAX_VALUE;
        List<Integer> min_list=new ArrayList<>();
        for(List<Integer> list:rs){
            int size=list.size();
            if(size<min){
                min_list=list;
                min=size;
            }
        }
        System.out.println(min_list.toString());
    }
}
