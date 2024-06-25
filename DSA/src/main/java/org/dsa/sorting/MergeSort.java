package org.dsa.sorting;

//time complexity nlogn
public class MergeSort {
    public void merge(int[] nums,int i,int mid, int j){
        int f = i;
        int s = mid+1;
        int len = j-i+1;
        int[] arr = new int[len];
        int ind=0;
        while(f<=mid && s<=j){
            if(nums[f]<=nums[s]){
                arr[ind]=nums[f++];
            }else{
                arr[ind]=nums[s++];
            }
            ind++;
        }
        while(f<=mid){
            arr[ind++]=nums[f++];
        }
        while(s<=j){
            arr[ind++]=nums[s++];
        }
        ind=0;
        while(ind<len){
            nums[i++]=arr[ind++];
        }
    }


    public void mergeSort(int[] nums,int i,int j){
        if(i>=j){
            return;
        }
        int mid = (i+j)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        merge(nums,i,mid,j);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}
