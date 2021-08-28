package utils;

public class TopN {
    public static void fun(int[] a,int m){
        for(int i=0;i<a.length;i++){
            for(int j=a.length-1;j>i;j--){
                int a1=a[j];
                int a2=a[j-1];
                if(a1<a2){
                    int t=a1;
                    a1=a2;
                    a2=t;
                    a[j]=a1;
                    a[j-1]=a2;
                }
            }
        }
        for(int i=0;i<m;i++){
            System.out.println(a[i]);
        }
    }
    public static void main(String[] args) {
        int[] array={1,2,4,8,3,1,9};
        fun(array,3);
    }
}
