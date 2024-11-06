package org.dsa.dp.stock;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution2 {
    int dp[][];
    public int stockHelper(int buy,int[] prices,int i){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy==1){
            int notBrought = stockHelper(1,prices,i+1);
            int brought = -prices[i] + stockHelper(0,prices,i+1);
            profit = Math.max(notBrought,brought);
        }else{
            int notSold = stockHelper(0,prices,i+1);
            int sold = prices[i] + stockHelper(1,prices,i+1);
            profit = Math.max(notSold,sold);
        }
        return dp[i][buy]=profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res =  stockHelper(1,prices,0);
        return res;
    }
}
public class InfiniteBuySell {
}
