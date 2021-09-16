package no165_compareVersion;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0,j=0;
        while(i<v1.length&&j<v2.length){
            String s1=v1[i];
            String s2=v2[j];
            if(Integer.parseInt(s1)>Integer.parseInt(s2)){
                return 1;
            }else if(Integer.parseInt(s1)<Integer.parseInt(s2)){
                return -1;
            }else{
                i++;
                j++;
                continue;
            }
        }
        while(i<v1.length){
            String s1=v1[i];
            if(Integer.parseInt(s1)>0){
                return 1;
            }else{
                i++;
                continue;
            }
        }
        while(j<v2.length){
            String s2=v2[j];
            if(Integer.parseInt(s2)>0){
                return -1;
            }else{
                j++;
                continue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.compareVersion("1.0","1.0.0"));
    }
}
