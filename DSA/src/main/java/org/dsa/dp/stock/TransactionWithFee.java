package org.dsa.dp.stock;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

class Solution {
    int dp[][];
    public int stockHelper(int buy,int[] prices,int i,int fee){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy==1){
            int notBrought = stockHelper(1,prices,i+1,fee);
            int brought = -prices[i] + stockHelper(0,prices,i+1,fee);
            profit = Math.max(notBrought,brought);
        }else{
            int notSold = stockHelper(0,prices,i+1,fee);
            int sold = prices[i] - fee + stockHelper(1,prices,i+1,fee);
            profit = Math.max(notSold,sold);
        }
        return dp[i][buy]=profit;
    }

    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res =  stockHelper(1,prices,0,fee);
        return res;
    }
}
public class TransactionWithFee {
}
