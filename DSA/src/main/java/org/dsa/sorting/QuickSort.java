package org.dsa.sorting;

public class QuickSort {
    public int partision(int[] nums,int low,int high){
        int pivot = nums[high];
        int i = low-1;
        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = pivot;
        nums[high] = temp;
        return i+1;
    }

    public void quickSort(int[] nums,int i,int j){
        if(i>=j) return;
        int k = partision(nums,i,j);
        quickSort(nums,i,k-1);
        quickSort(nums,k+1,j);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
}
