package org.dsa.dp.mcm;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossiblePalindromicPartioning {
    static List<List<String>> result;
    static List<String> list;
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
    public static void solve(String str,int index){
        if(index >= str.length()){
            result.add(new ArrayList<>(list));
            return ;
        }
        for(int k=index;k<str.length();k++){
            if(isPalindrome(str,index,k)){
                list.add(str.substring(index,k+1));
                solve(str,k+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String str) {
        int N = str.length();
        list = new ArrayList<>();
        result = new ArrayList<>();
        solve(str,0);
        return result;
    }
}
