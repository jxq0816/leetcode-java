package no76_minWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution2 {
    //t中所有的字符
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    //滑动窗口中所有的字符以及它们的个数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            //统计t中所有的字符以及它们的个数
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            //通过移动r指针不断扩张窗口
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                //统计滑动窗口中所有的字符以及它们的个数
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            //当窗口包含t全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    //收缩窗口
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    //检查当前窗口是否可行
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            //滑动窗口字符对应的个数小于t的哈希表中各个字符的个数，当前窗口不可行
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        //包含t的哈希表中的所有字符，并且对应的个数都不小于t的哈希表中各个字符的个数，当前窗口可行
        return true;
    }
    public static void main(String[] args) {
        String a="a";
        String t="a";
        Solution2 solution=new Solution2();
        System.out.println(solution.minWindow(a,t));
    }
}
