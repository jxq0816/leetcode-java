package no216_combinationSum3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] a={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> rs=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        dfs(a,list,rs,k,n,0);
        return rs;
    }
    void dfs(int[] a,List<Integer> list,List<List<Integer>> rs,int k,int target,int index){
        if(index==a.length){
            if(target==0&&list.size()==k){
                rs.add(new ArrayList<Integer>(list));
                return;
            }
            return;
        }
        if(target==0&&list.size()==k){
            rs.add(new ArrayList<Integer>(list));
            return;
        }
        dfs(a,list,rs,k,target,index+1);//不选
        if(target-a[index]>=0){//选择
            list.add(a[index]);
            dfs(a,list,rs,k,target-a[index],index+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> rs=solution.combinationSum3(9,45);
        for(List<Integer> list:rs){
            for(Integer i:list){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}
