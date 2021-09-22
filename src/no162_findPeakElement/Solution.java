package no162_findPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]>nums[i+1]){
                    return i;
                }
                continue;
            }
            if(i==n-1){
                if(nums[i-1]<nums[i]){
                    return i;
                }
                continue;
            }
            if(nums[i]>nums[i+1]&&nums[i-1]<nums[i]){
                return i;
            }
            if(nums[i]<nums[i+1]&&nums[i-1]>nums[i]){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution=new Solution();
        System.out.println(solution.findPeakElement(nums));
    }
}
