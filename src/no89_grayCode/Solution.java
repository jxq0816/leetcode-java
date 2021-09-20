package no89_grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<List<Integer>> paths=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        dfs(0,n,list,paths,new int[]{0,1});
        List<Integer> rs=new ArrayList<>();
        for(int i=0;i<paths.size();i++){
            List<Integer> code=paths.get(i);
            int val=0;
            for(int j=0;j<code.size();j++){
                val=val*2+code.get(j);
            }
            rs.add(val);
        }
        return rs;
    }
    void dfs(int depth,int n,List<Integer> list,List<List<Integer>> paths,int[] nums){
        if(depth==n){
            paths.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[0]);
        dfs(depth+1,n,list,paths,new int[]{0,1});
        list.remove(list.size()-1);

        list.add(nums[1]);
        dfs(depth+1,n,list,paths,new int[]{1,0});
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<Integer> rs=solution.grayCode(0);
        for(Integer i:rs){
            System.out.println(i);
        }
    }
}
