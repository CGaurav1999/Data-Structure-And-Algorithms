package org.dsa.recursion;

public class Permutations {
    private static void permutations(String s,String res){
        if(s.length()==0){
            System.out.println(res);
            return;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            permutations(left+right,res+ch);
        }
    }
    public static void main(String[] args) {
        permutations("abc","");
    }
}
