package org.dsa.binarySearch;

public class findMinInRotatedSortedArray {
    public int findMin(int[] arr) {
        int n = arr.length;
        int i=0;
        int j=n-1;
        if(arr[0]<=arr[n-1]){
            return arr[0];
        }
        int ans = Integer.MAX_VALUE;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(arr[mid]<=arr[(mid-1+n)%n] && arr[mid]<=arr[(mid+1)%n]){
                return arr[mid];
            }
            if(arr[i]>arr[mid]){
                ans = Math.min(ans,arr[mid]);
                j=mid-1;
            }
            else{
                ans = Math.min(ans,arr[i]);
                i=mid+1;
            }
        }
        return ans;
    }
}
