package org.dsa.lcs;

public class LongestCommonSubsequence {
    int [][]dp;
    public int solve(String text1,String text2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return dp[n][m] = 1+solve(text1,text2,n-1,m-1);
        }else{
            return dp[n][m] = Math.max(solve(text1,text2,n-1,m),solve(text1,text2,n,m-1));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(text1,text2,text1.length(),text2.length());
    }
}
