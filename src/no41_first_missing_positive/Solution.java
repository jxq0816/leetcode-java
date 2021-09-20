package no41_first_missing_positive;

import java.util.HashMap;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],1);
        }
        int i=1;
        while(map.get(i)!=null){
            i++;
        }
        return i;
    }
}
