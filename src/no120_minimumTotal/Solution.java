package no120_minimumTotal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> paths=new ArrayList<>();
        int level=triangle.size();
        dfs(triangle,0,0,path,paths);
        int rs=Integer.MAX_VALUE;
        for(List<Integer> list:paths){
            int tmp=0;
            for(Integer i:list){
                tmp+=i;
            }
            rs=Integer.min(tmp,rs);
        }
        return rs;
    }
    void dfs(List<List<Integer>> triangle,int depth,int index,List<Integer> path,List<List<Integer>> paths){
        if(depth>=triangle.size()){
            paths.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(triangle.get(depth).get(index));
        dfs(triangle,depth+1,index,path,paths);
        path.remove(path.size()-1);
        if(index+1<triangle.get(depth).size()){
            path.add(triangle.get(depth).get(index+1));
            dfs(triangle,depth+1,index+1,path,paths);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3=new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4=new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(solution.minimumTotal(triangle));
    }
}
