package nowcode_min_coins;

import java.util.*;
/**
 * 分别求aim-arr[i]的个数（0<=i<=n-1），当中最小值加一就是结果
   题目链接：https://www.nowcoder.com/questionTerminal/4e05294fc5aa4d4fa8eacef2e606e5a8
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[aim+1];
        dp[0] = 0;
        for(int i=1;i<=aim;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(nums[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i-nums[j]]);
            }
            dp[i] = dp[i]==Integer.MAX_VALUE?dp[i]:dp[i]+1;
        }
        System.out.println(dp[aim]==Integer.MAX_VALUE?-1:dp[aim]);
    }
}