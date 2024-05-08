package org.dsa.lcs.palindromeRelated;

//https://www.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class NoOfDeletionToMakeStringPalindrome {
    int minDeletions(String str1, int n)
    {
        String str2 = "";
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
        return n-dp[n][n];
    }
}
