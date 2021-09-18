package no74_searchMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=binarySearchRow(matrix,target);
        if(row==-1){
            return false;
        }
        int column=binarySearchColumn(matrix[row],target);
        if(column==-1){
            return false;
        }
        return true;
    }
    int binarySearchRow(int[][] matrix, int target){
        int low=0,high=matrix.length-1;
        while(low<=high){
            if(low==high){
                return low;
            }
            int mid=(high+low)/2;
            if(matrix[mid][0]<=target && matrix[mid+1][0]>target){
                return mid;
            }
            if(matrix[mid][0]<target){
                low=mid+1;
            }
            if(matrix[mid][0]>target){
                high=mid-1;
            }
        }
        return -1;
    }
    int binarySearchColumn(int[] array, int target){
        int low=0,high=array.length-1;
        while(low<=high){
            int mid=(high+low)/2;
            if(array[mid]==target){
                return mid;
            }
            if(array[mid]<target){
                low=mid+1;
            }
            if(array[mid]>target){
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix={{1}};
        Solution solution=new Solution();
        Boolean bool=solution.searchMatrix(matrix,1);
        System.out.println(bool);
    }
}
