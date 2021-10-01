package no220_containsNearbyAlmostDuplicate;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int start,end;
            if(i-k<0){
                start=0;
            }else{
                start=i-k;
            }
            if(i+k>n-1){
                end=n-1;
            }else{
                end=i+k;
            }
            for(int j=start;j<=end;j++){
                if(i!=j&&Math.abs((long)nums[i]-(long)nums[j])<=t){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums={1,5,9,1,5,9};
        int[] nums={-2147483648,2147483647};
        Solution solution=new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums,1,1));
    }
}
