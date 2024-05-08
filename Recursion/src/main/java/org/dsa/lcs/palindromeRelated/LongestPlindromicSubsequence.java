package org.dsa.lcs.palindromeRelated;
//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPlindromicSubsequence {
    public int longestPalindromeSubseq(String str1) {
        String str2 = "";
        int n = str1.length();
        for(int i=n-1;i>=0;i--){
            str2 += str1.charAt(i);
        }
        int [][]dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
