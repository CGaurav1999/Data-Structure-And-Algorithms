package org.dsa.dp.stock;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
class Solution3 {
    int dp[][][];
    public int stockHelper(int buy,int[] prices,int i,int transaction){
        if(i==prices.length || transaction==0){
            return 0;
        }
        if(dp[i][buy][transaction]!=-1){
            return dp[i][buy][transaction];
        }
        int profit = 0;
        if(buy==1){
            int notBrought = stockHelper(1,prices,i+1,transaction);
            int brought = -prices[i] + stockHelper(0,prices,i+1,transaction);
            profit = Math.max(notBrought,brought);
        }else{
            int notSold = stockHelper(0,prices,i+1,transaction);
            int sold = prices[i] + stockHelper(1,prices,i+1,transaction-1);
            profit = Math.max(notSold,sold);
        }
        return dp[i][buy][transaction]=profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }

        }
        int res =  stockHelper(1,prices,0,2);
        return res;
    }
}
public class TwoTransaction {
}
