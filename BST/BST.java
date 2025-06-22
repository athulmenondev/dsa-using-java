package BST;

import java.util.ArrayList;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
        //creating a tree
        public static  Node buildTree(int Value,Node root){
            if(root==null){
                root= new Node(Value);
                return root;
            }
            if(Value<root.data){
                root.left=buildTree(Value, root.left);
            }
            else{
                root.right=buildTree(Value, root.right);
            }
            return root;
        }
        //inorder traversal
        public static void inOrder(Node root){
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+"  ");
            inOrder(root.right);
            return;
        }
        //search for a key ,returns true or false
        public static boolean searchBst(Node root,int  key){
            if(root==null){
                return false;
            }
            if(root.data==key){
                return true;
            }
            if(key<root.data){
                return  searchBst(root.left,key);
            }else{
                return  searchBst(root.right,key);
            }

        }

        //find next Node in inOrder traversal
        public static Node findInorderSucesor(Node root){
            while (root.left!=null){
                root=root.left;
            }
            return root;
        }
        //delete a node
        public static Node deleteNode(Node root, int key){
            if(root==null){
                System.out.println("Key not found!!");
                return root;
            }
            if (key< root.data) {
                root.left=deleteNode(root.left,key);
            } else if (key> root.data) {
                root.right=deleteNode(root.right,key);
            }else{
                //case1(lead node)
                if(root.left==null && root.right==null){
                    return null;
                } else if (root.left!=null && root.right!=null) {
                    Node iS=findInorderSucesor(root.right);
                    root.data= iS.data;
                    root.right= deleteNode(root.right, iS.data);
                }else{
                    if(root.left==null){
                        return root.right;
                    }else{
                        return root.left;
                    }
                }
            }
            return  root;
        }
        public static void printRange(Node root,int x, int y){
            if(root==null){
                return;
            }
            if(root.data>=x && root.data<=y){
                printRange(root.left,x,y);
                System.out.print(root.data+"   ");
                printRange(root.right,x,y);
            } else if (y<=root.data) {
                printRange(root.left,x,y);
            }else{
                printRange(root.right,x,y);
            }
        }
        public static void printPath(ArrayList<Integer> paths){
            for (int i = 0; i < paths.size(); i++) {
                System.out.print(paths.get(i)+"--->");
            }
            System.out.println();
        }
        public static void findPath(Node root, ArrayList<Integer> paths){
            if(root==null){
                return;
            }
            paths.add(root.data);
            if (root.left ==null && root.right==null){
                printPath(paths);
            }else {
                findPath(root.left,paths);
                findPath(root.right,paths);
            }
            paths.remove(paths.size()-1);
        }
    }
    public static void main(String[] args) {
        int Values[]={5,1,7,6,8,3,9};
        Node root=null;
        for (int i = 0; i < Values.length; i++) {
           root=Node.buildTree(Values[i],root);
        }
        Node.inOrder(root);
        //System.out.println(Node.searchBst(root,2));
        //root=Node.deleteNode(root,8);
        System.out.print("\n");
        //Node.inOrder(root);
        //Node.printRange(root,5,8);
        Node.findPath(root,new ArrayList<Integer>());
    }
}
