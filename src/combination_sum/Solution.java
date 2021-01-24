package combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> combine=new ArrayList<Integer>();
        dfs(candidates,ans,target,combine,0);
        return ans;
    }
    void dfs(int[] candidates,List<List<Integer>> ans,int target, List<Integer> combine, int idx){
        if(idx==candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates,ans,target,combine,idx+1);
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,ans,target-candidates[idx],combine,idx);
            combine.remove(combine.size() - 1);
            //回溯框架，进行下一步之前加入当前节点，下一步递归过之后，要把当前节点从路径中删除，所以才是“回溯”。
        }
    }
}
