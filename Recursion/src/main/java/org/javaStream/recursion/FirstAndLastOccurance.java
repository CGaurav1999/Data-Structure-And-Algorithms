package org.javaStream.recursion;

import java.util.ArrayList;

public class FirstAndLastOccurance {
    private int first(int arr[],int n,int x,int ind){
        if(ind==n) return -1;
        if(arr[ind]==x) return ind;
        return first(arr,n,x,ind+1);
    }
    private int last(int arr[],int ind,int x){
        if(ind==-1) return -1;
        if(arr[ind]==x) return ind;
        return last(arr,ind-1,x);
    }
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(first(arr,n,x,0));
        list.add(last(arr,n-1,x));
        return list;
        // code here
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,3,6};
        FirstAndLastOccurance obj = new FirstAndLastOccurance();
        System.out.println(obj.find(arr,6,3));
    }
}
