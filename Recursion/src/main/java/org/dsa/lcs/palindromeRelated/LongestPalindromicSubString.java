package org.dsa.lcs.palindromeRelated;

public class LongestPalindromicSubString {
    public String helper(String s,int i,int j){
        int n = s.length();
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    public String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1){
            return s;
        }
        String ans = new String();
        int n = s.length();
        for(int i=0;i<n-1;i++){
            String temp1 = helper(s,i,i);
            String temp2 = helper(s,i,i+1);
            ans = temp1.length() > ans.length() ? temp1 : ans;
            ans = temp2.length() > ans.length() ? temp2 : ans;
        }
        return ans.toString();
    }
}
