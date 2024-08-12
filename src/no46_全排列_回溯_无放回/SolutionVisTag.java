//题目描述：https://xingqijiang.blog.csdn.net/article/details/113621106

package no46_全排列_回溯_无放回;

import java.util.ArrayList;
import java.util.List;

class SolutionVisTag {
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
            //选择i
            perm.add(nums[i]);
            vis[i]=true;
            //进入到第i+1层
            backtrack(nums,index+1);
            //回溯
            vis[i]=false;
            perm.remove(index);
        }
    }

    public static void main(String[] args) {
        SolutionVisTag solution=new SolutionVisTag();
        int[] array={1,2,3};
        List<List<Integer>> rs=solution.permute(array);
        for(List<Integer> list:rs){
            System.out.println(list.toString());
        }
    }
}