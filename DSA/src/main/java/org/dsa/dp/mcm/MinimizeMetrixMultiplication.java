package org.dsa.dp.mcm;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class MinimizeMetrixMultiplication {
    static int [][]dp;
    public static int solve(int[] arr,int i,int j){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans,temp);
        }
        return dp[i][j] = ans;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,1,N-1);
    }
}
