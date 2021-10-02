package no115_numDistinct;

class Solution2 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        //如果t是s的子序列，则s的长度一定大于或等于t的长度,如果 m<n，则t一定不是s的子序列，因此直接返回 0。
        if (m < n) {
            return 0;
        }
        //s[i:] 表示 s从下标 i 到末尾的子字符串，t[j:] 表示 t 从下标 j 到末尾的子字符串。
        //dp[i][j] 表示在 s[i:]的子序列中 t[j:]出现的个数,默认值全为0
        int[][] dp = new int[m + 1][n + 1];
        //当 i=m且 j<n时，s[i:]为空字符串，t[j:] 为非空字符串，由于非空字符串不是空字符串的子序列，因此对任意0≤j<n，有dp[m][j]=0。
        //当 j=n时，t[j:] 为空字符串，由于空字符串是任何字符串的子序列，因此对任意0≤i≤m，有 dp[i][n]=1；
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                //当 s[i]=t[j]时
                if (sChar == tChar) {
                    //①如果 s[i] 和 t[j]匹配，则考虑 t[j+1:]作为 s[i+1:]的子序列，子序列数为 dp[i+1][j+1]；
                    //②如果 s[i]不和 t[j]匹配，则考虑 t[j:]作为 s[i+1:] 的子序列，子序列数为 dp[i+1][j]。
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    //s[i]!=t[j] 时，s[i]不能和 t[j]匹配，因此只考虑 t[j:]作为 s[i+1:]的子序列，子序列数为dp[i+1][j]
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        System.out.println(solution2.numDistinct("rabbbit","rabbit"));
    }
}