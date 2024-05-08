package org.dsa.recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AllSubSequences {
    public static List<String> printSubSequencesUsingBitManupulation(String str){
        int n=  str.length();
        List<String> list = new ArrayList<>();
        for(int i=0;i<(1<<n);i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    temp += str.charAt(j);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static void printSubSequencesUsingRecursion(String str,String res,int ind){
        if(ind==str.length()){
            System.out.println(res);
            return;
        }
        printSubSequencesUsingRecursion(str,res,ind+1);
        res+=str.charAt(ind);
        printSubSequencesUsingRecursion(str,res,ind+1);
    }

    public static void main(String[] args) {
        String str = "abc";
//        List<String> outputStr = printSubSequencesUsingBitManupulation(str);
//        Collections.sort(outputStr,new cmp());
//        System.out.println(outputStr);

        printSubSequencesUsingRecursion(str,"",0);
    }
}

class cmp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}
