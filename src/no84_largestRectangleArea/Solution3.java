package no84_largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Deque;
public class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        //在输入数组的两端加上两个高度为0
        int[] newHeights = new int[len + 2];
        //头部的0是为了不用判断栈是否为空, 因为题目中都是非负整数, 所以没有数会比0小, 即0一直会在栈底.
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        //尾部的0是为了压出最后已经形成的单调栈的
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(heights[0]);
        for (int i = 1; i < len; i++) {
            //这个while很关键，因为有可能不止一个柱形的最大宽度可以被计算出来,栈顶元素为当前柱形的下标
            //小于栈顶柱形高度时，开始计算柱形高度对应的最大面积
            while (heights[i] < heights[stack.peekLast()]) {
                int curIndex=stack.pollLast();
                //当前高度
                int curHeight = heights[curIndex];
                int curWidth = i - stack.peekLast() - 1;
                System.out.println("curIndex = " +  (curIndex-1) + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            //大于等于栈顶柱形高度时，入栈
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        Solution3 solution = new Solution3();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}