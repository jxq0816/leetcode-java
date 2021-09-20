package no36_is_valid_sudoku;

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len=board.length;
        for(int i=0;i<len;i++){
            if(!checkRow(board,i)){
                System.out.println("第"+i+"行验证失败");
                return false;
            }else{
                System.out.println("第"+i+"行验证成功");
            }
        }
        for(int i=0;i<len;i++){
            if(!checkColumn(board,i)){
                System.out.println("第"+i+"列验证失败");
                return false;
            }
            else{
                System.out.println("第"+i+"列验证成功");
            }
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                if (!checkMatrix(board, i*3, j*3)) {
                    return false;
                }
                else{
                    System.out.println("第"+i*3+","+j*3+"矩阵验证成功");
                }
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board,int row){
        int len=board.length;
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(Character.forDigit(i,10),0);
        }
        for(int i=0;i<len;i++){
            if(board[row][i]!='.'){
                if(map.get(board[row][i])>=1){
                    return false;
                }else{
                    map.put(board[row][i],map.get(board[row][i])+1);
                }
            }
        }
        return true;
    }
    public boolean checkColumn(char[][] board,int column){
        int len=board.length;
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(Character.forDigit(i,10),0);
        }
        for(int i=0;i<len;i++){
            if(board[i][column]!='.'){
                if(map.get(board[i][column])>=1){
                    return false;
                }else{
                    map.put(board[i][column],map.get(board[i][column])+1);
                }
            }
        }
        return true;
    }
    public boolean checkMatrix(char[][] board,int rowStart,int columnStart){
        int len=board.length;
        Map<Character, Integer> map=new HashMap<>();
        for(int n=0;n<10;n++){
            map.put(Character.forDigit(n,10),0);
        }
        int rowEnd=rowStart+3;
        int columnEnd=columnStart+3;
        System.out.println("i:"+rowStart+"->"+rowEnd);
        System.out.println("j:"+columnStart+"->"+columnEnd);
        for(int i=rowStart;i<rowEnd;i++){
            for(int j=columnStart;j<columnEnd;j++) {
                System.out.println(i+","+j+":"+board[i][j]);
                if(board[i][j]!='.'){
                    if (map.get(board[i][j]) >= 1) {
                        return false;
                    } else {
                        map.put(board[i][j], map.get(board[i][j]) + 1);
                        System.out.println(map);
                    }
                }
            }
        }
        System.out.println(map);
        return true;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board));
    }

}

