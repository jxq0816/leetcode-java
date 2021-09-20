package no40_combination_sum2;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rs=new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return rs;
        }
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(candidates.length);
        dfs(candidates,rs,path,target,0);
        return rs;
    }
    void dfs(int[] candidates, List<List<Integer>> rs, Deque<Integer> path, int target, int index){
        if(target==0){
            rs.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates,rs,path,target-candidates[i],i+1);
            path.removeLast();
            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
