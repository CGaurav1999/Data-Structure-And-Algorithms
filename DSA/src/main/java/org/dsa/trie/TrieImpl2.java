package org.dsa.trie;

//https://www.naukri.com/code360/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
class Node2{
    private Node2[] arr = new Node2[26];
    private int endsHere = 0;
    private int endsPrefix = 0;

    public void increaseEndsHere(){
        endsHere++;
    }

    public void increaseEndsPrefix(){
        endsPrefix++;
    }

    public int getEndsHere(){
        return endsHere;
    }

    public int getEndsPrefix(){
        return endsPrefix;
    }

    public Node2 getNextNode(char ch){
        return arr[ch-'a'];
    }

    public boolean containsNode(char ch){
        return (arr[ch-'a'] != null);
    }

    public void put(char ch){
        arr[ch-'a'] = new Node2();
    }
    public void decreaseEndsPrefix(){
        endsPrefix--;
    }
    public void decreaseEndsHere(){
        endsHere--;
    }

}
class Trie {

    private Node2 root;
    public Trie() {
        root = new Node2();
    }

    public void insert(String word) {
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsNode(ch)){
                node.put(ch);
            }
            node = node.getNextNode(ch);
            node.increaseEndsPrefix();
        }
        node.increaseEndsHere();
    }

    public int countWordsEqualTo(String word) {
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsNode(ch)){
                node = node.getNextNode(ch);
            }else{
                return 0;
            }
        }
        return node.getEndsHere();
    }

    public int countWordsStartingWith(String word) {
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsNode(ch)){
                node = node.getNextNode(ch);
            }else{
                return 0;
            }
        }
        return node.getEndsPrefix();
    }

    public void erase(String word) {
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsNode(ch)){
                node = node.getNextNode(ch);
                node.decreaseEndsPrefix();
            }else{
                return;
            }
        }
        node.decreaseEndsHere();
    }

}

public class TrieImpl2 {
}
