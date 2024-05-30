package no46_permute_无重复无放回;
import java.util.ArrayList;

public class DFS {
    ArrayList rs=new ArrayList<>();
    ArrayList list=new ArrayList<>();
    boolean[] visit;

    public ArrayList fun(int[] a){
        visit=new boolean[a.length];
        dfs(a,0);
        return rs;
    }

    public void dfs(int[] a, int index){
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
            dfs(a,index+1);
            list.remove(list.size()-1);
            visit[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] a={1,2,3};
        DFS dfs=new DFS();
        ArrayList<ArrayList<Integer>> rs=dfs.fun(a);
        for(ArrayList<Integer> list:rs){
            System.out.println(list.toString());
        }
    }
}