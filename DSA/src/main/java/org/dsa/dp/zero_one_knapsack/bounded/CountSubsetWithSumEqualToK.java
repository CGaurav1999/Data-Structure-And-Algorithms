package org.dsa.dp.zero_one_knapsack.bounded;

public class CountSubsetWithSumEqualToK {
    public static void main(String[] args) {
        int n = 4;
        int k = 6;

        int arr[] =  {1, 2, 3, 3};
        int dp[][] = new int[n+1][k+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else{
                    if(arr[i-1]<=j){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n][k]);

    }
}
