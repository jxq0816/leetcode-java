package no93_restoreIpAddresses;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {//ip已被分为4段
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {//每个ip段最多有3位
            if (i >= len) {
                break;
            }
            if (residue * 3 < len - i) {//剩下的位数太长，即使每个ip段都3位，都凑不出正确的ip地址，剪枝
                break;
            }
            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);
                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();//回溯
            }
        }
    }
    //监测从left->right是否能组成ip段
    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {//0.011.255.245无效
            return false;
        }
        int res = 0;//转化为整数
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}