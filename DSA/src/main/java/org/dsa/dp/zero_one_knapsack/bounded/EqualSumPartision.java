package org.dsa.dp.zero_one_knapsack.bounded;

public class EqualSumPartision {
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += arr[i];
        }
        if(sum%2 != 0){
            return 0;
        }
        int W = sum/2;
        boolean[][] dp = new boolean[N+1][W+1];

        for(int i=0;i<=N;i++){
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
        return dp[N][W] == true ? 1 : 0;
    }
}
