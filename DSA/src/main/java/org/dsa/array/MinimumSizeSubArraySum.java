package org.dsa.array;

public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i=0,j=0;
        int sum = 0;
        int ans = n+1;
        while(j<n){
            sum+=nums[j];
            if(sum>=target){
                while(i<=j && sum-nums[i]>=target){
                    sum-=nums[i++];
                }
                int cnt = j-i+1;
                ans = Math.min(ans,cnt);
            }
            j++;
        }
        return ans==n+1?0:ans;
    }
}
