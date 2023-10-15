package sort;

public class QuickSortPartition {
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
    public void quickSort(int[] a,int start,int end){
        if(start<end){
            int mid=partition(a,start,end);
            quickSort(a,0,mid-1);//左侧快排
            quickSort(a,mid+1,end);//右侧快排
        }
        return;
    }
    public static void main(String[] args) {
        QuickSortPartition instance = new QuickSortPartition();
        int[] a={1,2,5,4,3};
        instance.quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
