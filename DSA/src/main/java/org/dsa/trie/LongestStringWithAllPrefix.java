package org.dsa.trie;

import java.util.* ;
import java.io.*;

//https://www.naukri.com/code360/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos

class Node3{
    Node3[] arr = new Node3[26];
    boolean ended = false;
    public Node3 next(char ch){
        return arr[ch-'a'];
    }
    public boolean containsNode(char ch){
        return arr[ch-'a'] != null;
    }
    public void put(char ch){
        arr[ch-'a'] = new Node3();
    }
    public void end(){
        ended=true;
    }
}
class Trie3{
    private Node3 root;
    Trie3(){
        root = new Node3();
    }
    public void insert(String word){
        Node3 node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsNode(word.charAt(i))){
                node.put(word.charAt(i));
            }
            node=node.next(word.charAt(i));
        }
        node.end();
    }
    public boolean containsAllPrefixes(String word){
        Node3 node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsNode(word.charAt(i))){
                node = node.next(word.charAt(i));
                if(node.ended==false){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution {

    public static String completeString(int n, String[] s) {
        Trie3 trie = new Trie3();
        for(int i=0;i<n;i++){
            trie.insert(s[i]);
        }

        String longest = "";
        for(int i=0;i<n;i++){
            if(trie.containsAllPrefixes(s[i])){

                if(s[i].length()>longest.length()){
                    longest = s[i];
                }
                if((s[i].length() == longest.length()) && (s[i].compareTo(longest)<0)){
                    longest = s[i];
                }
            }
        }
        return longest.length() == 0 ? "None" : longest;
    }
}
public class LongestStringWithAllPrefix {
}
