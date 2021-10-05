package no85_maximalRectangle;

public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null){
            return 0;
        }
        int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length;
        int rs=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int l=n;
                    for(int k=i;k<m;k++){
                        for(int f=j;f<l;f++){
                            if(matrix[k][f]=='1'){
                                int area=(k-i+1)*(f-j+1);
                                System.out.println("("+i+","+j+")->("+k+","+f+") "+area);
                                rs=Math.max(rs,area);
                            }else{
                                l=f;
                                break;
                            }
                        }
                    }

                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        //char[][] matrix={};
        //char[][] matrix={{'1'}};
        //char[][] matrix={{'1','0'},{'1','0'}};
        char[][] matrix={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        //char[][] matrix={
        //        {'1','1','1','1','1','1','1','1'},
        //        {'1','1','1','1','1','1','1','0'},
        //        {'1','1','1','1','1','1','1','0'},
        //        {'1','1','1','1','1','0','0','0'},
        //        {'0','1','1','1','1','0','0','0'}
        //};
        System.out.println(solution2.maximalRectangle(matrix));
    }
}
