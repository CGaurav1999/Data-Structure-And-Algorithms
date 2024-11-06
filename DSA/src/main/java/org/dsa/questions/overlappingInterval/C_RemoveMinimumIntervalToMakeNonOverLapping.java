package org.dsa.questions.overlappingInterval;

import java.util.Arrays;
import java.util.Comparator;

public class C_RemoveMinimumIntervalToMakeNonOverLapping {
    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals,new Cmp());
        int n = intervals.length;
        int ans = 0;
        int left = 0;
        int right = 1;
        while(right<n){
            if(intervals[left][1]<=intervals[right][0]){ //non-overlapping
                left=right;
                right++;
            }else if(intervals[left][1]<=intervals[right][1]){ //overlapping case-1
                ans++;                                        //leaving the right one
                right++;
            }else if(intervals[left][1]>intervals[right][1]){ //overlapping case-2
                ans++;                                       //leaving the left one
                left=right;
                right++;
            }
        }
        return ans;
    }
}

class Cmp implements Comparator<int[]> {
    @Override
    public int compare(int[] a,int[] b){
        return a[0]-b[0];
    }
}
