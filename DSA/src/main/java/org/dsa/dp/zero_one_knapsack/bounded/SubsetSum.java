package org.dsa.dp.zero_one_knapsack.bounded;

public class SubsetSum {
    static Boolean isSubsetSum(int n, int arr[], int W){
        boolean[][] dp = new boolean[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=false;
                }
                else if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}
