package no49_groupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Set set=new HashSet<>();
        HashMap<Map,List<String>> map=new HashMap();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            Map<Character,Integer> wordCount=new HashMap<>();
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                int cnt=wordCount.getOrDefault(c,0);
                wordCount.put(c,cnt+1);
            }
            List<String> list= (List<String>) map.getOrDefault(wordCount,new ArrayList<String>());
            list.add(str);
            map.put(wordCount,list);
        }
        List<List<String>> rs=new ArrayList<>();
        for(List<String> list:map.values()){
            rs.add(list);
        }
        return rs;
    }
}
