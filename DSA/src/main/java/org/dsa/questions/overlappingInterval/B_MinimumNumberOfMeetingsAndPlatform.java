package org.dsa.questions.overlappingInterval;

import java.util.Arrays;

public class B_MinimumNumberOfMeetingsAndPlatform {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        int index = 0;
        for(int[] interval: intervals){
            startTime[index] = interval[0];
            endTime[index++] = interval[1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int i = 0, j = 0;
        int activate = 0, max = 0;
        while(i < len && j < len){
            if(startTime[i] < endTime[j]){
                activate++;
                i++;
            }else{
                activate--;
                j++;
            }
            max = Math.max(max, activate);
        }
        return max;
    }
}
