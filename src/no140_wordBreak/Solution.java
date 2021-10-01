package no140_wordBreak;

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //哈希表存储字符串 s 的每个下标和从该下标开始的部分可以组成的句子列表
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        //使用哈希集合存储单词列表中的单词，这样在判断一个字符串是否是单词列表中的单词时只需要判断该字符串是否在哈希集合中即可
        // 而不再需要遍历单词列表。
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        //如果到某个下标发现无法匹配，则哈希表中该下标对应的是空列表，因此可以对不能拆分的情况进行剪枝优化
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            //遍历背包
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                //遍历物品
                if (wordSet.contains(word)) {
                    //从i下标开始的部分可以组成的句子列表
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        //在对 s 的剩余部分拆分得到一个句子之后，将拆分出的第一个单词（即s的前缀）添加到句子的头部，即可得到一个完整的句子
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        //如果遇到已经访问过的下标，则可以直接从哈希表得到结果
        return map.get(index);
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
