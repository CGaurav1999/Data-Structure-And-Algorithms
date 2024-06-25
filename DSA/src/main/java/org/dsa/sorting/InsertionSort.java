package org.dsa.sorting;

import java.util.Arrays;

//Time complexity O(N2) in all the cases
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,5,2,7,6};
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            int ele = arr[i];
            int j = i+1;
            while(j<n){
                if(arr[j]<ele){
                    arr[j-1]=arr[j];
                }else{
                    break;
                }
                j++;
            }
            arr[j-1]=ele;
        }
        System.out.println(Arrays.toString(arr));
    }
}
