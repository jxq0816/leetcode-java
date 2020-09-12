package max_area;

public class Solution {
    public int maxArea(int[] height) {
        int rs=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int area=Integer.min(height[i],height[j])*(j-i);
                rs=(rs>area)?rs:area;
            }
        }
        return rs;
    }
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        Solution solution=new Solution();
        int rs=solution.maxArea(height);
        System.out.println(rs);
    }
}
