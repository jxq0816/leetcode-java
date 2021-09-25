package no139_wordBreak;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //dp[i] 表示 s 的前 i 位是否可以用 wordDictwordDict 中的单词表示
        dp = new boolean[n+1];
        dp[0]=true;
        //遍历背包
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                //遍历物品
                for(String word:wordDict){
                    if(dp[i]&&s.substring(i,j).equals(word)){
                        dp[j]=true;
                    }

                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        String s = "leetcode";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak(s,wordDict));
    }
}
