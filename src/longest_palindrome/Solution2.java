package longest_palindrome;

public class Solution2 {

    public String longestPalindrome(String s) {
        // 特判
        int n = s.length();
        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[n][n];
        String rs="";
        for (int k = 0;  k< n; ++k) {
            for (int i = 0; i+k < n; i++) {
                int j=i+k;
                System.out.println(j);
                if(k==0){
                    dp[i][j]=true;
                }else if(k==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && k + 1 > rs.length()) {
                    rs = s.substring(i,i+k+1);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        String rs=solution2.longestPalindrome("cbbd");
        System.out.println(rs);
    }
}