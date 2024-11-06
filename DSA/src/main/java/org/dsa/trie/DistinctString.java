package org.dsa.trie;


import java.util.ArrayList;

class Node{
    Node[] arr = new Node[26];
    public boolean containsNode(char ch){
        return arr[ch-'a'] != null;
    }
    public void put(char ch){
        arr[ch-'a']=new Node();
    }
    public Node next(char ch){
        return arr[ch-'a'];
    }
}

public class DistinctString {
    public static int countDistinctSubstrings(String s)
    {
        Node root = new Node();
        int cnt=1;
        for(int i=0;i<s.length();i++){
            Node node = root;
            for(int j=i;j<s.length();j++){
                if(!node.containsNode(s.charAt(j))){
                    cnt++;
                    node.put(s.charAt(j));
                }
                node = node.next(s.charAt(j));
            }
        }
        return cnt;
    }
}
