package org.dsa.dp;

import java.util.ArrayList;

public class MinimumSubsetSumDifference {
    public int minDifference(int arr[], int n){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        boolean[][] dp = new boolean[n+1][sum/2+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum/2;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else{
                    if(arr[i-1]<=j)
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=sum/2;i++){
            if(dp[n][i]){
                int temp = sum-2*i;
                ans = Math.min(ans,temp);
            }
        }

        return ans;
    }
}
