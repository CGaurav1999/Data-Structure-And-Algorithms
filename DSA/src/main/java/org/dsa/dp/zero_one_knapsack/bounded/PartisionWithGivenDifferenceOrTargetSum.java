package org.dsa.dp.zero_one_knapsack.bounded;

public class PartisionWithGivenDifferenceOrTargetSum {
    public static int countPartitions(int n, int d, int[] arr) {
        int mod = 1000000007;
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        if(d>sum){
            return 0;
        }
        if((sum+d)%2 != 0){
            return 0;
        }
        sum = (sum+d)/2;
        int [][]dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else{
                    if(arr[i-1]<=j){
                        dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]]) % mod;
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][sum];
    }

}
