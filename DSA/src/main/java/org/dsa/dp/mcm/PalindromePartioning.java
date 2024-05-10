package org.dsa.dp.mcm;

import java.util.Arrays;

public class PalindromePartioning {
    static int [][]dp;
    public static boolean isPalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int solve(String str,int i,int j){
        if(i>=j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(isPalindrome(str,i,j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = 1;
            if(dp[i][k] != -1){
                temp+=dp[i][k];
            }else{
                dp[i][k] = solve(str,i,k);
                temp += dp[i][k];
            }
            if(dp[k+1][j] != -1){
                temp+=dp[k+1][j];
            }else{
                dp[k+1][j] = solve(str,k+1,j);
                temp += dp[k+1][j];
            }
            ans = Math.min(ans,temp);
        }
        return dp[i][j] = ans;
    }
    static int palindromicPartition(String str)
    {
        int N = str.length();
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(str,0,N-1);

    }
}
