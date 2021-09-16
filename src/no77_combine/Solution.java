import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] candidates=new int[n];
        for(int i=0;i<n;i++){
            candidates[i]=i+1;
        }
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Set<Integer> list=new HashSet<Integer>();
        dfs(candidates,ans,list,0,k);
        return ans;
    }
    void dfs(int[] candidates,List<List<Integer>> ans, Set<Integer> set, int idx,int k){
        if(idx==candidates.length){
            return;
        }
        if(set.size()==k){
            ans.add(new ArrayList<Integer>(set));
            return;
        }
        dfs(candidates,ans,set,idx+1,k);
        if(set.size()<k){
            set.add(candidates[idx]);
            dfs(candidates,ans,set,idx,k);
            set.remove(set.size() - 1);
            //回溯框架，进行下一步之前加入当前节点，下一步递归过之后，要把当前节点从路径中删除，所以才是“回溯”。
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> rs=solution.combine(4,2);
        for(List<Integer> list:rs){
            for(Integer i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}