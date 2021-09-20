package no59_generateMatrix;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int k=0;
        int m=1;
        int i,j;
        while(k<n/2){
            for(j=k;j<n-k;j++){
                rs[k][j]=m++;
            }
            for(i=k+1,j--;i<n-k;i++){
                rs[i][j]=m++;
            }
            for(i--,j--;j>k;j--){
                rs[i][j]=m++;
            }
            for(;i>k;i--){
                rs[i][j]=m++;
            }
            k++;
        }
        if(n%2==1){
            rs[n/2][n/2]=m++;
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=3;
        int[][] rs=solution.generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(rs[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
