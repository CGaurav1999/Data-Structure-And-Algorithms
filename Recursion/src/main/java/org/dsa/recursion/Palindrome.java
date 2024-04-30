package org.dsa.recursion;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int i=0,j=str.length()-1;
        boolean flag = true;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                flag=false;
                break;
            }
            i++;
            j--;
        }
        if(flag){
            System.out.println("palindrome");
        }else{
            System.out.println("not a palindrome");
        }
    }
}
