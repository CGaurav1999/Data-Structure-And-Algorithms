package org.dsa.sorting;

import java.util.Arrays;

//Time complexity
//best O(N2)
//worst O(N2)
//average O(N2)
//If we use flag best can be O(N)  CASE if array is already sorted
public class BubbleSort {
    public static void main(String[] args) {
        int []arr = new int[]{5,3,4,1,2};
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}