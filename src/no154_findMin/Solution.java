package no154_findMin;

public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if(nums[pivot] < nums[high]){
                high=pivot;
            }else if(nums[pivot] > nums[high]){
                low=pivot+1;
            }else{
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        //int[] nums={3,1,3};
        int[] nums={10,1,10,10,10};
        System.out.println(solution.findMin(nums));
    }
}
