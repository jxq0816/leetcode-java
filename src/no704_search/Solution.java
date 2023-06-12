package no704_search;

public class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                low=mid+1;
            }
            if(nums[mid]>target){
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        Solution solution=new Solution();
        System.out.println(solution.search(nums,3));
        System.out.println(solution.search(nums,2));
    }
}
