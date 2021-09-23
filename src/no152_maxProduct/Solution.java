package no152_maxProduct;

public class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int rs=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product*=nums[j];
                rs=Math.max(rs,product);
            }
        }
        return rs;
    }
}
