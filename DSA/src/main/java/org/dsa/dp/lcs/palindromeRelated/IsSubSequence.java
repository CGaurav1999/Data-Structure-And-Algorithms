package org.dsa.dp.lcs.palindromeRelated;

public class IsSubSequence {
    public boolean isSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m]==n;
    }

    //alternate
    public boolean isSubsequenceApproach2(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int index = 0;
        for (char c : t1) {
            if (index < s1.length && s1[index] == c) {
                index++;
            }
        }
        return index == s1.length;
    }
}
