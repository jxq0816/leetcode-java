package no91_numDecodings;

public class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] f=new int[n+1];
        f[0]=1;
        for(int i=1;i<=n;i++){
            //s[i] 进行解码
            if(s.charAt(i-1)!='0'){
                f[i]+=f[i-1];
            }
            //s[i-1] 和 s[i]进行编码
            if(i>1&&s.charAt(i-2)!='0'&&(10*(s.charAt(i-2)-'0')+(s.charAt(i-1)-'0'))<=26){
                f[i]+=f[i-2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numDecodings("1"));
    }
}
