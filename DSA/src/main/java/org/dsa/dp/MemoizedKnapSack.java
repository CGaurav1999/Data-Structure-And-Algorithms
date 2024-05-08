package org.dsa.dp;

import java.util.Arrays;

public class MemoizedKnapSack {
    static int knapSackHelper(int[][] dp,int W, int wt[], int val[], int n)
    {
        // your code here
        if(n==0 || W<=0){
            return 0;
        }

        //visited
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        //can pick the element
        if(wt[n-1]<=W){
            return dp[n][W] = Math.max(val[n-1] + knapSackHelper(dp,W-wt[n-1],wt,val,n-1),
                    knapSackHelper(dp,W,wt,val,n-1));
        }

        //can't pick
        else{
            return dp[n][W] = knapSackHelper(dp,W,wt,val,n-1);
        }

    }

    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return knapSackHelper(dp,W,wt,val,n);

    }
}
