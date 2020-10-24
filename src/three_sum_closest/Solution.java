package three_sum_closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i + 1, right = nums.length - 1;
            while(left<right){
                int threeSum = nums[left] + nums[right] + nums[i];
                if(Math.abs(threeSum-target)<Math.abs(closestNum-target)){
                    closestNum=threeSum;
                }
                if(threeSum>target){
                    right--;
                } else if(threeSum<target){
                    left++;
                } else {
                    return threeSum;
                }
            }
        }
        return closestNum;
    }
}
