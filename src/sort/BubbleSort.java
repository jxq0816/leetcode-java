package sort;

public class BubbleSort {

    public static int sort(int a[]) {
        int n=a.length;
        int cnt=0;
        //用冒泡排序法将序列A中的元素按从小到大排序
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;//表示本趟冒泡是否发生交换的标志
            for (int j = n - 1; j > i; j--) {//一趟冒泡过程
                if (a[j - 1]> a[j]) {//若为逆序
                    int t=a[j-1];
                    a[j-1]=a[j];
                    a[j]=t;
                    flag = true;
                    cnt++;
                }
            }
            if (flag == false) {
                return cnt;//本趟遍历后没有发生交换，说明表已经有序
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int a[]={4,1,5,2};
        int cnt=sort(a);
        for(int k=0;k<a.length;k++){
            System.out.println(a[k]);
        }
        System.out.println("交换"+cnt+"次");

    }
}