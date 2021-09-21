package no187_findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> sites = new HashSet<String>();
        HashMap map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n-9;i++){
            String subStr=s.substring(i,i+10);
            if(map.containsKey(subStr)){
                sites.add(subStr);
            }else{
                map.put(subStr,1);
            }
        }
        return new ArrayList<>(sites);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<String> rs=solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        //List<String> rs=solution.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        for(String s:rs){
            System.out.println(s);
        }
    }
}
