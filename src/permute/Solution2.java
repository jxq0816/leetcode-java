package permute;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis=new boolean[nums.length];
        backtrack(nums,res, 0,perm);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int idx,List<Integer> perm) {
        // 所有数都填完了
        if (idx == nums.length) {
            res.add(new ArrayList<Integer>(perm));
            return;
        }
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

    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        int[] array={1,2,3};
        List<List<Integer>> rs=solution.permute(array);
        for(List<Integer> list:rs){
            for(Integer i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}