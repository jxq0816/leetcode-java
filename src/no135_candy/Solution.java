package no135_candy;

public class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                a[i]=a[i-1]+1;
            }else{
                a[i]=1;
            }
        }
        int right=0,rs=0;
        for(int i=n-1;i>=0;i--){
            if(i<n-1&&ratings[i]>ratings[i+1]){
                right++;
            }else{
                right=1;
            }
            rs+=Math.max(a[i],right);
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] ratings={1,0,2};
        System.out.println(solution.candy(ratings));
    }
}
