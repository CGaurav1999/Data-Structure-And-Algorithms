package org.dsa.dp.zero_one_knapsack.un_bounded;

//unbounded knapsack
public class UnboundedKnapSack {
    static int knapSack(int n, int w, int val[], int wt[]){
        int [][]dp = new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    if(wt[i-1]<=j){
                        dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]] , dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][w];
    }
}
