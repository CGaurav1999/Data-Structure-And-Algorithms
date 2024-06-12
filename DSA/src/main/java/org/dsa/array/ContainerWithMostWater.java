package org.dsa.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int capacity = 0;
        int i=0,j=height.length-1;
        while(i<j){
            int currentCapacity = Math.min(height[i],height[j]) * (j-i);
            capacity = Math.max(capacity,currentCapacity);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return capacity;
    }
}
