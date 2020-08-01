package find_median_sorted_arrays;

public class Solution {
    public int[] merge(int[] nums1, int[] nums2){
        int len1=nums1.length;
        int len2=nums2.length;
        int len3=len1+len2;
        int[] nums3=new int[len3];
        int i=0,j=0,k=0;
        while(i<len1&&j<len2){
            int num1=nums1[i];
            int num2=nums2[j];
            if (num1>num2){
                nums3[k++]=num2;
                j++;
            }else{
                nums3[k++]=num1;
                i++;
            }
        }
        while(i<len1){
            nums3[k++]=nums1[i++];
        }
        while(j<len2){
            nums3[k++]=nums2[j++];
        }
        return nums3;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3=merge(nums1,nums2);
        int len3=nums3.length;
        for(int i=0;i<len3;i++){
            System.out.println(nums3[i]);
        }
        double rs;
        if(len3%2==1){
            rs=nums3[len3/2];
        }else{
            rs=1.0*(nums3[len3/2-1]+nums3[len3/2])/2;
        }
        return rs;
    }
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        Solution solution=new Solution();
        double rs=solution.findMedianSortedArrays(nums1,nums2);
        System.out.println(rs);
    }
}
