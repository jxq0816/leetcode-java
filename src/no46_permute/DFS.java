package no46_permute;
import java.util.ArrayList;

public class DFS {

    boolean[] visit;

    public ArrayList<ArrayList<Integer>> fun(int[] a){
        ArrayList<ArrayList<Integer>> rs=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        visit=new boolean[a.length];
        dfs(rs,list,a,0);
        return rs;
    }

    public void dfs(ArrayList<ArrayList<Integer>> rs, ArrayList<Integer> list, int[] a, int index){
        if(index==a.length){
            rs.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<a.length;i++){
            if(visit[i]){
                continue;
            }
            list.add(a[i]);
            visit[i]=true;
            dfs(rs,list,a,index+1);
            list.remove(list.size()-1);
            visit[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3};
        DFS dfs=new DFS();
        ArrayList<ArrayList<Integer>> rs=dfs.fun(a);
        for(ArrayList<Integer> list:rs){
            for(Integer i:list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
