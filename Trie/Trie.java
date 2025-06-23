package Trie;

public class Trie {
    static class Node {
        Node children[];
        boolean eow;
        public Node(){
            children= new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i]=null;
            }
            this.eow=false;
        }    
    }
    static Node root = new Node();
    static Node currNode;
    public static void  insert(String s){
        currNode=root;
        for (int i = 0; i < s.length(); i++) {
            int idx=s.charAt(i)-'a';
            if(currNode.children[idx]==null){
                currNode.children[idx]=new Node();
            }
            if (i==s.length()-1){
                currNode.children[idx].eow=true;
            }
            currNode=currNode.children[idx];
        }
    }
    public static boolean searchTrie(String s){
        currNode=root;
        for (int i = 0; i < s.length(); i++) {
            int idx=s.charAt(i)-'a';
            if (currNode.children[idx]==null) {
                return false;
            }
            if (i==s.length()-1 && currNode.children[idx].eow==false) {
                return false;
            }
            currNode=currNode.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String s){
        if(s.length()==0){
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix=s.substring(0, i);
            String suffix=s.substring(i);
            if(searchTrie(prefix) && wordBreak(suffix)){
                return true;
            }
        }
        return false;

    }
    public static boolean startWith(String s){
        currNode=root;
        for (int i = 0; i < s.length(); i++) {
            int idx= s.charAt(i)-'a';
            if(currNode.children[idx]==null){
                return false;
            }
            currNode=currNode.children[idx];
        }
        return true;
    }
    public static int findNumberOfNodes(Node currNode){
        if(currNode==null){
            return 0;
        }
        int count=1;
        for (int i = 0; i < 26; i++) {
            if(currNode.children[i]!=null){
                count+=findNumberOfNodes(currNode.children[i]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // String[] c={"there","thier","therafter","took","also","and"};
        // for (int i = 0; i < c.length; i++) {
        //     insert(c[i]);
        // }
        // System.out.println(searchTrie("there"));
        // System.out.println(searchTrie("took"));
        String[] arr={"apple","app","mango","man","woman"};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        // System.out.println(searchTrie("i"));
        // System.out.println(searchTrie("like"));
        // System.out.println(searchTrie("samsung"));
        // System.out.println(wordBreak("ilikesamsung"));
        // System.out.println(startWith("moon"));
        System.out.println(findNumberOfNodes(root));
    }
}