package org.dsa.array;

import java.util.*;

public class ThreeSum {
    Set<List<Integer>> set;
    public void solve(int[] nums,int i,int j,int ele){
        while(i<j){
            int sum = nums[i]+nums[j]+ele;
            if(sum==0){
                set.add(List.of(ele,nums[i],nums[j]));
                int ii = i+1;
                while(ii<j && nums[ii]==nums[i]){
                    ii++;
                }
                i=ii;
                int jj = j-1;
                while(jj>i && nums[jj]==nums[j]){
                    jj--;
                }
                j=jj;
            }else if(sum>0){
                j--;
            }else{
                i++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            solve(nums,i+1,n-1,nums[i]);
        }
        result = new ArrayList<>(set);
        return result;
    }
}
