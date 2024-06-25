package org.dsa.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

//All case O(N2)
public class SelectionSort {
    public static void main(String[] args) {
        int []arr = {4,2,3,5,1};
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int smallest = arr[i];
            int ind = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<smallest){
                    smallest=arr[j];
                    ind=j;
                }
            }
            int temp = arr[i];
            arr[i]=smallest;
            arr[ind]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
