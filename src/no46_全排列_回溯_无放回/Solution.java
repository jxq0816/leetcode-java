package no46_全排列_回溯_无放回;

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> output = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] nums) {

        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, 0);
        return res;
    }

    public void backtrack(int n, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n,first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] array={1,2,3};
        List<List<Integer>> rs=solution.permute(array);
        for(List<Integer> list:rs){
            System.out.println(list.toString());
        }
    }
}