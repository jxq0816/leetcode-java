package no153_findMin;

public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len-1;i++) {
            if(nums[i] > nums[i+1]) {
                return nums[i+1];
            }
        }
        return nums[0];
    }
}


