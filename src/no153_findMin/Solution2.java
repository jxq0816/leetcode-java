package no153_findMin;

public class Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        int[] nums={1,3,3};
        System.out.println(solution2.findMin(nums));
    }
}