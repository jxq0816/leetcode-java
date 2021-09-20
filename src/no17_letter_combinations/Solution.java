package no17_letter_combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<String>();
        if (digits.length() == 0) {
            return rs;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(rs, phoneMap, digits, 0, new StringBuffer());
        return rs;
    }

    public void backtrack(List<String> rs, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            //index表示已经处理完了第几个数字,处理完最后一个数字,返回结果
            rs.add(combination.toString());
        } else {
            //开始处理第index个数字
            char digit = digits.charAt(index);
            //获取数字对应的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                //开始处理第index+1个数字
                backtrack(rs, phoneMap, digits, index + 1, combination);
                //进行回退操作，遍历其余的字母排列
                combination.deleteCharAt(index);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<String> rs = solution.letterCombinations("23");
        for(String s :rs){
            System.out.println(s);
        }
    }
}
