package no73_setZeroes;

import javafx.util.Pair;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Set<Pair> map=new HashSet();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    map.add(pair);
                }
            }
        }
        for(Pair<Integer, Integer> pair : map){
            setZero(pair.getKey(),pair.getValue(),matrix);
        }
    }
    public void setZero(int i,int j,int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int k=0;k<m;k++){
            matrix[k][j]=0;
        }
        for(int k=0;k<n;k++){
            matrix[i][k]=0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        Solution solution=new Solution();
        solution.setZeroes(matrix);
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }
}