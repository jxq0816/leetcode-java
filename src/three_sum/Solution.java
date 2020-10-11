package three_sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> rs=new HashSet<>();
        int len=nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> match=new ArrayList<>();
                        match.add(nums[i]);
                        match.add(nums[j]);
                        match.add(nums[k]);
                        if(!rs.contains(match)){
                            rs.add(match);
                        }
                    }
                }
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(List<Integer> l:rs){
            list.add(l);
        }
        return list;
    }
}