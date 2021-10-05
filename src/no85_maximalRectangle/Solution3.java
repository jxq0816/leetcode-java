package no85_maximalRectangle;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length<=0)
            return 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols+2];
        // 在左右两侧添加两个哨兵
        // 左侧的哨兵使得不用判空
        heights[0] = 0;
        // 尾部的哨兵能在遍历结束时弹出前面的柱子计算面积
        heights[cols+1] = 0;
        int max=0;
        //可以把每一行当作一组height然后求得每一行得最大矩形，然后不断增加行，不断更新height
        for(int row=0;row<matrix.length;row++){
            //转化为柱状图
            for(int j=0;j<cols;j++){
                if(matrix[row][j]=='1'){
                    heights[j+1]++;
                }else
                    heights[j+1] = 0;
            }
            //求的每一行作为最底层的最大矩形,更新最大值
            max = Math.max(max,largestRectangleArea(heights));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len==0)
            return 0;
        if(len==1)
            return heights[0];

        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        // 添加哨兵，使得不用判断空
        deque.addLast(0);
        for(int i=1;i<len;i++){
            // 形成递增单调栈，弹出比当前元素大的元素
            // 同时开始计算前面不同高度的矩形面积，因为当前元素是前面矩形的宽度的边界
            while(heights[i]<heights[deque.peekLast()]){
                // 以当前柱子高度作为矩形的高度
                int currHeight = heights[deque.pollLast()];
                while(currHeight==heights[deque.peekLast()])
                    deque.pollLast();
                // 得到矩形左边的边界
                int currWidth = i - deque.peekLast() -1;
                max = Math.max(max, currWidth*currHeight);
            }
            deque.addLast(i);
        }
        return max;
    }
}
