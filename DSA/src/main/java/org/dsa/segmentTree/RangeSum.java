package org.dsa.segmentTree;

import java.util.ArrayList;
import java.util.List;

public class RangeSum {
    int segment[];
    public void createSegment(int i,int l,int r,int[] arr){
        if(l==r){
            segment[i]=arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        createSegment(i*2+1,l,mid,arr);
        createSegment(i*2+2,mid+1,r,arr);
        segment[i]=segment[2*i+1]+segment[2*i+2];
    }
    public int query(int i,int l,int r,int left,int right){
        if(r<left || l>right){
            return 0;
        }
        if(left<=l && right>=r){
            return segment[i];
        }
        int mid = l + (r-l)/2;
        return query(i*2+1,l,mid,left,right)+query(i*2+2,mid+1,r,left,right);
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[])
    {
        segment = new int[4*n];
        createSegment(0,0,n-1,arr);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<q*2;i+=2){
            ans.add(query(0,0,n-1,queries[i]-1,queries[i+1]-1));
        }
        return ans;
    }
}
