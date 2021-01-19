package search_range;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=searchIndexFirst(nums,0,nums.length-1,target);
        int last=searchIndexLast(nums,0,nums.length-1,target);
        int[] rs={first,last};
        return rs;
    }

    public int searchIndexFirst(int[] nums, int low,int high,int target) {
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target&&low==high){
            return mid;
        }
        if(nums[mid]==target&&(mid==0||nums[mid-1]<nums[mid])){
            return mid;
        }
        if(target<=nums[mid]){
            //寻找第一个位置，当目标值小于等于中间值，往左寻找
            return searchIndexFirst(nums,low,mid-1,target);
        }else{
            return searchIndexFirst(nums,mid+1,high,target);
        }
    }
    public int searchIndexLast(int[] nums, int low,int high,int target) {
        if(low>high){
            return -1;
        }
        int mid=(low+high)/2;
        if(nums[mid]==target&&low==high){
            return mid;
        }
        if(nums[mid]==target&&nums[mid]<nums[mid+1]){
            return mid;
        }
        if(target>=nums[mid]){
            //寻找最后一个位置，当目标值大于等于中间值，往右寻找
            return searchIndexLast(nums,mid+1,high,target);
        }else{
            return searchIndexLast(nums,low,mid-1,target);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution=new Solution();
        int[] rs = solution.searchRange(nums, 8);
        for(int i=0;i<rs.length;i++){
            System.out.println(rs[i]);
        }
    }
}
