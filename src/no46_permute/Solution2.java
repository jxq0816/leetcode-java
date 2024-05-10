package no46_permute;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {

        vis=new boolean[nums.length];
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int index) {
        // 所有数都填完了
        if(index==nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]){
                continue;
            }
            perm.add(nums[i]);
            vis[i]=true;
            backtrack(nums,index+1);
            vis[i]=false;
            perm.remove(index);
        }
    }

    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        int[] array={1,2,3};
        List<List<Integer>> rs=solution.permute(array);
        for(List<Integer> list:rs){
            System.out.println(list.toString());
        }
    }
}