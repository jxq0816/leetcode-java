package no39_combination_sum_无重复有放回;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List ans=new ArrayList<List<Integer>>();
    List combine=new ArrayList<Integer>();

    public List combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return ans;
    }
    void dfs(int[] candidates,int target, int idx){
        if(idx==candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates,target,idx+1);//不选择
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],idx);//选择
            combine.remove(combine.size() - 1);
            //回溯框架，进行下一步之前加入当前节点，下一步递归过之后，要把当前节点从路径中删除，所以才是“回溯”。
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> rs=solution.combinationSum(new int[]{2,3,6,7},7);
        for(List<Integer> list:rs){
            System.out.println(list.toString());
        }
    }
}
