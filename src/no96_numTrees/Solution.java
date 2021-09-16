package no96_numTrees;

public class Solution {
    public int numTrees(int n) {
        int[] g= new int[n+1];
        g[0]=1;
        g[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                g[i]+=g[j]*g[i-j];
            }
        }
        return g[n];
    }
}
