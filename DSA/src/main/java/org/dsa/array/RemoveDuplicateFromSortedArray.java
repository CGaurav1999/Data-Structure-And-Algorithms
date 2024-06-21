package org.dsa.array;

public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while(j<nums.length){
            while(j<nums.length && nums[j]==nums[i]){
                j++;
            }
            if(j<nums.length){
                nums[++i]=nums[j];
                j++;
            }
        }
        return ++i;
    }
}
