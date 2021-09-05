package isInterleave97;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if(n1+n2!=n3){
            return false;
        }
        boolean[][] bool=new boolean[n1+1][n2+1];
        bool[0][0]=true;
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                int p=i+j-1;
                if(i>0){
                    bool[i][j]=bool[i][j]||bool[i-1][j]&&s1.charAt(i-1)==s3.charAt(p);
                }
                if(j>0){
                    bool[i][j]=bool[i][j]||bool[i][j-1]&&s2.charAt(j-1)==s3.charAt(p);
                }
            }
        }
        return bool[n1][n2];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        System.out.println(solution.isInterleave(s1,s2,s3));
    }
}
