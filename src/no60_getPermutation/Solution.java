package no60_getPermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static boolean[] vis;
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis=new boolean[nums.length];
        backtrack(nums,res, 0,perm);
        return res;
    }

    public static void backtrack(int[] nums, List<List<Integer>> res, int idx,List<Integer> perm) {
        // 所有数都填完了
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
        //本层集合中元素
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]){
                continue;
            }
            perm.add(nums[i]);
            vis[i]=true;
            backtrack(nums, res, idx+1, perm);
            vis[i]=false;
            perm.remove(idx);
        }
    }
    public static String getPermutation(int n, int k) {
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=i+1;
        }
        List<Integer> list=permute(array).get(k-1);
        String rs="";
        for(Integer i:list){
            rs+=i;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }
}
