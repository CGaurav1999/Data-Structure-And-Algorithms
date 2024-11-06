package org.dsa.questions.overlappingInterval;

import java.util.Arrays;
import java.util.Comparator;

public class A_MergeInterval {
    class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            Arrays.sort(intervals,new cmp());

            int start=intervals[0][0];
            int end = intervals[0][1];
            int[][] ans = new int[n][2];
            int index = 0;
            for(int i=1;i<n;i++){
                if(intervals[i][0]<=end){
                    end=Math.max(end,intervals[i][1]);
                }else{
                    ans[index][0]=start;
                    ans[index][1]=end;
                    index++;
                    start=intervals[i][0];
                    end=intervals[i][1];
                }
            }
            ans[index][0]=start;
            ans[index][1]=end;
            index++;

            return  Arrays.copyOfRange(ans, 0, index);

        }
    }
    class cmp implements Comparator<int[]> {
        @Override
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
    }
}
