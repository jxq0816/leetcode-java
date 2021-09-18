package no48_rotate;

public class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int k=0;k<=n/2;k++){//圈数
            int len=n-k*2;//框的边长
            for(int i=0;i<len-1;i++){
                int t=matrix[k][k+i];//上边备份1,2,3
                matrix[k][k+i]=matrix[k+len-i-1][k];//左边旋转到上边(0,0)=(2,0){7} (0,1)=(1,0){4}
                matrix[k+len-i-1][k]=matrix[k+len-1][k+len-i-1];//下边旋转到左边(2,0)=(2,2){9},(1,0)=(2,1){8}
                matrix[k+len-1][k+len-i-1]=matrix[k+i][k+len-1];//右边旋转到下边(2,2)=(0,2){3},(2,1)=(1,2){6}
                matrix[k+i][k+len-1]=t;//上边旋转到右边(0,2)=(0,0){1},(1,2)=(0,1){2}
            }
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }
}
