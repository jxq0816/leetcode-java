package no132_minCut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    boolean[][] f;
    List<String> ans = new ArrayList<String>();
    int n;
    public int minCut(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                //判断任意 s[i..j]是否为回文串了
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        //rs[i] 表示字符串的前缀 s[0..i] 的最少分割次数
        int[] rs=new int[n];
        Arrays.fill(rs, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            //假如s[0..i] 本身就是一个回文串，此时不需要进行任何分割
            if(f[0][i]){
                rs[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    //假如以j位置切分, s[j+1..i] 是一个回文串
                    if(f[j+1][i]){
                        //f[i] 就可以从f[j]转移而来，附加1次额外的分割次数
                        rs[i]=Integer.min(rs[i],rs[j]+1);
                    }
                }
            }
        }
        return rs[n-1];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minCut("ab"));
    }
}
