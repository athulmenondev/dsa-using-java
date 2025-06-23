package Trie;

public class LongestWord {
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
    static String str="";
    public static void fiindLongestWord(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null && root.children[i].eow==true){
                temp.append((char)(i+'a'));
                if(temp.length()>str.length()) {
                    str=temp.toString();
                }
                fiindLongestWord(root.children[i], temp);
                 temp.deleteCharAt(temp.length()-1);
            }
        }
       
    }
    public static void main(String[] args) {
        String[] words= {"a","banana","app","appl","ap","apply","apple"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        fiindLongestWord(root, new StringBuilder(""));
        System.out.println(str);
    }
}
