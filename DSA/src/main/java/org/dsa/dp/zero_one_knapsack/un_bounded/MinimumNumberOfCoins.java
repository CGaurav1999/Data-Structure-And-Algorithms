package org.dsa.dp.zero_one_knapsack.un_bounded;

//unbounded knapsack
public class MinimumNumberOfCoins {
    public int minCoins(int coins[], int n, int amount)
    {
        int dp[][] = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    dp[i][j]=0;
                }else if(i==0){
                    dp[i][j]=Integer.MAX_VALUE-1;
                }else{
                    if(coins[i-1]<=j){
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }
}
