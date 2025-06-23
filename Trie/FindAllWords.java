package Trie;

import java.util.ArrayList;

public class FindAllWords {
    static class Node {
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            eow=false;
        }
    }
    static Node root= new Node(); 
    static Node currNode = new Node();
    static int n=1;
    public static void buildTrie(String s){
        currNode=root;
        for (int i = 0; i < s.length() ; i++) {
            int idx= s.charAt(i)-'a';
            if(currNode.children[idx]==null){
                currNode.children[idx]=new Node();
                n++;
                System.out.println("new node created for "+s.charAt(i));
            }
            if(i==s.length()-1){
                currNode.children[idx].eow=true;
            }
            currNode=currNode.children[idx];
        }
    }
    public static ArrayList<String> findAllUniqueSuffixes(String s,ArrayList<String> l){
        for (int i = 0; i <=s.length(); i++) {
            l.add(s.substring(i));
        }
        return l;
    }

    public static int findAllsubstring(String str){
        ArrayList<String> uniqueSubstrings= findAllUniqueSuffixes(str, new ArrayList<String>());
        System.out.println(uniqueSubstrings);
        for (int i = 0; i < uniqueSubstrings.size()-1; i++) {
             System.out.println("Current word = "+uniqueSubstrings.get(i));
            buildTrie(uniqueSubstrings.get(i));
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println(findAllsubstring("ababa"));
    }
}
