package sort;

public class QuickSort {
    public static void quickSort(int low, int high, int[] array){
        if(low>=high){
            return;
        }
        int i=low,j=high,x=array[low];
        while(i<j){
            while(i<j&&array[j]>=x){// 从右向左找第一个小于x的数
                j--;
            }
            array[i]=array[j];
            while(i<j&&array[i]<x){// 从左向右找第一个大于x的数
                i++;
            }
            array[j]=array[i];
        }
        array[i]=x;
        quickSort(low,i-1,array);
        quickSort(i+1,high,array);
        return;
    }
    public static void main(String[] args) {
        QuickSort instance = new QuickSort();
        int[] array={1,2,5,4,3};
        instance.quickSort(0,array.length-1,array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
