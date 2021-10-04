package no84_largestRectangleArea;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            // 小于栈顶柱形高度时，开始计算柱形高度对应的最大面积
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                //当前高度
                int curIndex=stack.pollLast();
                int curHeight = heights[curIndex];
                //中间那些相等的柱形可以当做不存在
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                System.out.println("curIndex = " +  curIndex+ " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        //遍历完成以后，栈中还有元素
        while (!stack.isEmpty()) {
            int curIndex=stack.pollLast();
            int curHeight = heights[curIndex];
            //中间那些相等的柱形可以当做不存在
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            System.out.println("curIndex = " +  curIndex+ " " + curHeight * curWidth);
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        //int[] heights = {1, 1};
        Solution2 solution = new Solution2();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
