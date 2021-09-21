package no139_wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        dp = new boolean[length];
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(0, length, s, dict);
    }
    public boolean dfs(int start, int length, String s, Set<String> wordDict){
        if(start==length){
            return true;
        }
        if(dp[start]){//记忆化搜索
            return true;
        }
        for(int i=start;i<length;i++){
            String subStr=s.substring(start,i+1);
            if(wordDict.contains(subStr)&&dfs(i+1,length,s,wordDict)){
                dp[start]=true;//记忆化搜索，记录以start开始的子串是可以被拆分的
                return true;
            }
        }
        dp[start]=false;//记忆化搜索，记录以start开始的子串是不可以被拆分的
        return false;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s = "leetcode";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(solution.wordBreak(s,wordDict));
    }
}
