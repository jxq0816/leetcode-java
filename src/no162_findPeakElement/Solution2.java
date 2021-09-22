package no162_findPeakElement;

class Solution2 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            //峰值，直接返回 i
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {//右侧上升趋势
                left = mid + 1;
            } else {//右侧下降趋势
                right = mid - 1;
            }
        }
        return ans;
    }

    // 辅助函数，输入下标 i，返回一个二元组 (0/1, nums[i])
    // 0对应边界情况， nums[-1]或nums[n]
    // 1对应数组元素， nums[0]...nums[n-1]
    public int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        return new int[]{1, nums[idx]};
    }

    public int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {//比较边界nums[-1]或nums[n]与其他数组元素
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {//数组内元素比较
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;//数组内元素比较
    }
}