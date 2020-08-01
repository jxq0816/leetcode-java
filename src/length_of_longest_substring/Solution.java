package length_of_longest_substring;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int result = 0;
        int start = 0;  // 左指针初始位置
        int end = 0;    // 右指针初始位置
        //哈希集合，记录每个字符是否出现过
        HashSet<Character> subset = new HashSet<>();
        subset.add(s.charAt(0)); // 先把第0个字符放入Set

        while (start < len) {
            // 先判断长度，再判断是否包含字符，避免越界
            // end初始位置是0，0号字符已被加入集合，从下一个字符开始计算
            while (end + 1 < len && ! subset.contains(s.charAt(end + 1)) ) {
                subset.add(s.charAt(++end));
            }
            result = Math.max(result, end - start + 1);
            if (end + 1 == len) { // 右指针移动到最后，可以终止计算，不需要再循环
                break;
            }
            subset.remove(s.charAt(start));
            start ++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int rs=solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(rs);
    }
}