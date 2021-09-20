package no88_merge;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            int n1=nums1[i];
            int n2=nums2[j];
            //当nums1数组中的有效元素遍历完毕，将nums2的剩余元素插入到nums1的尾部
            if(i>=nums1.length-n+j){
                insert(nums1,i++,n2);
                j++;
                continue;
            }
            if(n1<=n2){
                i++;
            }else{
                //当nums1[i]>nums2[j]时，nums1数组下标i及以后的元素全部后移一个位置，将nums2[j]插入到nums1下标为i的位置
                insert(nums1,i++,n2);
                j++;
            }
        }
    }
    public void insert(int[] nums1, int index, int insertValue) {
        for(int i=nums1.length-1;i>index;i--){
            nums1[i]=nums1[i-1];
        }
        nums1[index]=insertValue;
    }
    public static void main(String[] args) {
        int[] nums1={-1,0,0,3,3,3,0,0,0};
        int[] nums2={1,2,2};
        Solution solution=new Solution();
        solution.merge(nums1,3,nums2,3);
        for(int k=0;k<nums1.length;k++){
            System.out.print(nums1[k]+",");
        }
        System.out.println();
    }
}