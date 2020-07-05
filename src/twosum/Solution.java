package twosum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=target-nums[i];
            if(map.containsKey(x)){
                return new int[]{map.get(x),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={2,7,11,15};
        int[] rs=solution.twoSum(nums,9);
        for (Integer item : rs){
            System.out.println(item);
        }
    }
}
