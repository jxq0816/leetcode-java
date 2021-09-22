package no134_canCompleteCircuit;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        //从第i个加油站出发
        for(int i=0;i<n;i++){
            //到达下一站，油量剩余
            int residue=0;
            //环形下标
            int j=i;
            //一共走了几站
            int k=0;
            while(1==1){
                //当前油量无法到达下一站j+1
                if(residue+gas[j]-cost[j]<0){
                    break;
                }else{
                    //到达下一站j+1后剩余油量
                    residue=residue+gas[j]-cost[j];
                }
                //下一站
                j=(j+1)%n;
                k++;
                if(k>=n){
                    //油量足够达到第n站，即形成环
                    if(residue>=0){
                        return i;
                    }else{
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] gas  = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(solution.canCompleteCircuit(gas,cost));
        int[] gas2  = {1,2,3,4,5};
        int[] cost2 = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas2,cost2));
        int[] gas3  ={4,5,2,6,5,3};
        int[] cost3 = {3,2,7,3,2,9};
        System.out.println(solution.canCompleteCircuit(gas3,cost3));
    }
}
