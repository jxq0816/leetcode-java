package no1_twosum;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        int[] nums={2,7,11,15};
        int[] rs=solution.twoSum(nums,9);
        for (Integer item : rs){
            System.out.println(item);
        }
    }
}
