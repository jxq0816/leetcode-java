package no39_combination_sum;

import java.util.ArrayList;
import java.util.List;

/*
 * 以最小的金币个数，组成指定金额
 * */

public class LessCoins {
    public static List rs=new ArrayList();
    public static List list=new ArrayList();

    public static List solution(int[] a,int t){
        dfs(a,t,0);
        return rs;
    }
    public static void dfs(int[] a,int t,int i){
        if(i==a.length){
            return;
        }
        if(t==0){
            rs.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(a,t,i+1);
        if(t-a[i]>=0){
            list.add(a[i]);
            dfs(a,t-a[i],i);
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
