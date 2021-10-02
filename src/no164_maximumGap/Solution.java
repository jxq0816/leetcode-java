package no164_maximumGap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==0||n==1){
            return 0;
        }
        int rs=0;
        for(int i=1;i<n;i++){
            rs=Math.max(rs,nums[i]-nums[i-1]);
        }
        return rs;
    }
}
