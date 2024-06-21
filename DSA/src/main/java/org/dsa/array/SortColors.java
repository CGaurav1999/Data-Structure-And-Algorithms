package org.dsa.array;

public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0, zero = -1, two = nums.length;
        while(i<two){
            if(nums[i]==0){
                zero++;
                nums[i]=nums[zero];
                nums[zero]=0;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                two--;
                nums[i]=nums[two];
                nums[two]=2;
            }
        }
    }
}
