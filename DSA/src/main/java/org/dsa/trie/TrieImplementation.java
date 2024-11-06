package org.dsa.trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/
class Node1 {
    private Node1[] arr = new Node1[26];
    private boolean ends = false;
    public boolean containsChar(char ch){
        return (arr[ch-'a'] != null);
    }
    public void insert(char ch, Node1 newNode){
        arr[ch-'a'] = newNode;
    }
    public Node1 move(char ch){
        return arr[ch-'a'];
    }
    public void finish(){
        ends = true;
    }
    public boolean endsHere(){
        return ends != false;
    }
}

class Trie1 {

    private Node1 root;

    public Trie1() {
        root = new Node1();
    }

    public void insert(String word) {
        Node1 node = root;
        for(int i=0 ; i<word.length() ; i++){
            if(!node.containsChar(word.charAt(i))){
                node.insert(word.charAt(i),new Node1());
            }
            node = node.move(word.charAt(i));
        }
        node.finish();
    }

    public boolean search(String word) {
        Node1 node = root;
        for(int i=0 ; i<word.length() ; i++){
            if(!node.containsChar(word.charAt(i))){
                return false;
            }
            node = node.move(word.charAt(i));
        }
        return node.endsHere();
    }

    public boolean startsWith(String prefix) {
        Node1 node = root;
        for(int i=0 ; i<prefix.length() ; i++){
            if(!node.containsChar(prefix.charAt(i))){
                return false;
            }
            node = node.move(prefix.charAt(i));
        }
        return true;
    }
}

public class TrieImplementation {
}
