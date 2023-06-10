package sort;

public class QuickSortPartition {
    public int partition(int[] array,int low,int high){
        int pivot=array[low];
        while(low<high){
            while(low<high&&array[high]>=pivot){
                high--;
            }
            array[low]=array[high];
            while(low<high&&array[low]<=pivot){
                low++;
            }
            array[high]=array[low];
        }
        array[low]=pivot;
        return low;
    }
    public void quickSort(int[] array,int start,int end){
        if(start<end){
            int mid=partition(array,start,end);
            quickSort(array,0,mid-1);//左侧快排
            quickSort(array,mid+1,end);//右侧快排
        }
        return;
    }
    public static void main(String[] args) {
        QuickSortPartition instance = new QuickSortPartition();
        int[] array={1,2,5,4,3};
        instance.quickSort(array,0,array.length-1);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
