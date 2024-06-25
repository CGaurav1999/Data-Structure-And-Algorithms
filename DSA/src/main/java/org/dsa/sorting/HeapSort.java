package org.dsa.sorting;

//time  complexity nlogn in all the cases
public class HeapSort {
    public void heapify(int[] nums,int i,int n){
        int largest = i;
        int l=i*2;
        int r=i*2+1;
        if(l<n && nums[largest]<nums[l])
            largest=l;
        if(r<n && nums[largest]<nums[r])
            largest=r;
        if(largest != i){
            int temp = nums[i];
            nums[i]=nums[largest];
            nums[largest]=temp;
            heapify(nums,largest,n);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i=n/2;i>=0;i--){
            heapify(nums,i,n);
        }
        for(int i=n-1;i>=0;i--){
            int temp = nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(nums,0,i);
        }
        return nums;
    }
}
