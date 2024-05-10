package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Qsort {
    public int partition(int[] a,int low,int high){
        int pivot=a[low];
        while(low<high){
            while(low<high&&a[high]>=pivot){
                high--;
            }
            a[low]=a[high];
            while(low<high&&a[low]<=pivot){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=pivot;
        return low;
    }
    public void sort(int[] a,int low,int high){
        if(low<high){
            int mid=partition(a,low,high);
            sort(a,low,mid-1);
            sort(a,mid+1,high);
        }
    }
    public static void main(String[] args) {
        int[] a={2,1,3};
        Qsort qsort=new Qsort();
        qsort.sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
