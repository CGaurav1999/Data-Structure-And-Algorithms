package org.dsa.recursion;

import java.util.Arrays;

public class Encodings {
    int x = 0;
    int[] dp;
    private int helper(String s){
        if(s.length()==0) return 1;
        if(dp[s.length()] != -1){
            return dp[s.length()];
        }
        int ans = 0;
        char ch = s.charAt(0);
        if(ch=='0') return 0;
        ans = dp[s.length()-1] = helper(s.substring(1));

        if(s.length()>=2){
            String str = s.substring(0,2);
            int ele = Integer.parseInt(str);
            if(ele>=10 && ele<=26){
                ans += dp[s.length()-2] = helper(s.substring(2));
            }
        }
        return dp[s.length()] =  ans;
    }
    public int numDecodings(String s) {
        dp = new int[105];
        Arrays.fill(dp, -1);
        return helper(s);


        // int n = s.length();
        // int[] dp = new int[n+1];
        // dp[0]=1;
        // if(s.charAt(0)!='0'){
        //     dp[1]=1;
        // }
        // for(int i=1;i<n;i++){
        //     char ch = s.charAt(i);
        //     int cnt = 0;
        //     if(ch>='1' && ch<='9'){
        //         dp[i+1]=dp[i];
        //     }
        //     String str = s.substring(i-1,i+1);
        //     int ele = Integer.parseInt(str);
        //     if(ele>=10 && ele<=26){
        //         dp[i+1] += dp[i-1];
        //     }
        // }
        // return dp[n];
    }

    public static void main(String[] args) {
        Encodings obj = new Encodings();
        System.out.println(obj.numDecodings("11111"));
    }
}
