package no912;

public class Solution {
    public int[] quickSort(int[] nums,int low,int high) {
        if(low>=high){
            return nums;
        }
        int i=low,j=high,pivot=nums[high];
        while(i<j){
            while(i<j&&nums[i]<pivot){//从左往右找大于中枢的
                i++;
            }
            nums[j]=nums[i];
            while(i<j&&nums[j]>=pivot){//从右往左找小于中枢的
                j--;
            }
            nums[i]=nums[j];
        }
        nums[i]=pivot;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
        return nums;
    }
    public int[] sortArray(int[] nums) {
        return quickSort(nums,0,nums.length-1);
    }
    public static void main(String[] args) {
        int[] nums={1,2,5,4,3,4};
        Solution solution=new Solution();
        int[] rs=solution.sortArray(nums);
        for(int i=0;i<rs.length;i++){
            System.out.println(rs[i]);
        }
    }
}
