package org.dsa.dp;

import java.util.Arrays;
//unbounded knapsack
public class TotalCombinationOfCoins {
    int[][] dp;
    public int helper(int amount,int[] coins,int n){
        if(amount==0){
            return 1;
        }
        if(n == 0 || amount<0){
            return 0;
        }
        if(dp[n][amount] != -1){
            return dp[n][amount];
        }
        if(coins[n-1]<=amount){
            return dp[n][amount] = helper(amount-coins[n-1],coins,n) + helper(amount,coins,n-1);
        }else{
            return dp[n][amount] = helper(amount,coins,n-1);
        }
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(amount,coins,n);
    }
}
