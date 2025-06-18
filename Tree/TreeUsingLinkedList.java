package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUsingLinkedList {

    static class  Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static class Tree {
            static int idx=-1;
            public static Node bulidTree(int nodes[] ){
                idx++;
                if (nodes[idx]==-1) {
                    return null;
                }
                Node newNode = new  Node(nodes[idx]);
                newNode.left=bulidTree(nodes);
                newNode.right=bulidTree(nodes);
                return newNode;
            }
            public static void preOrder(Node root){
                if (root==null) {
                    System.out.print(-1+"\t");
                    return;
                }
                System.out.print(root.data+"\t");
                preOrder(root.left);
                preOrder(root.right);
            }
            public static void inOrder(Node root){
                if (root==null) {
                    System.out.print(-1+"\t");
                    return;
                }
                inOrder(root.left);
                System.out.print(root.data+"\t");
                inOrder(root.right);
            }
            public static void postOrder(Node root){
                if (root==null) {
                    System.out.print(-1+"\t");
                    return;
                }
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data+"\t");
                
            }
            
            public static void levelOrderTraveral(Node root){
                Queue<Node> q = new LinkedList<>();
                q.add(root);
                q.add(null);
                while (!q.isEmpty()) {
                    Node currentNode=q.remove();
                    if (currentNode==null) {
                        System.out.println();
                        if (q.isEmpty()) {
                            break;
                        }else{
                            q.add(null);
                        }
                    }else{
                        System.err.print(currentNode.data+"\t");
                        if (currentNode.left!=null) {
                            q.add(currentNode.left);
                        }
                        if (currentNode.right!=null) {
                            q.add(currentNode.right);
                        }
                    }
                }
            }
        }
        public static void main(String[] args) {
            int nodes[]={1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            Node root=Tree.bulidTree(nodes);
            //Tree.levelOrderTraveral(root);
            //Tree.preOrder(root);
            //Tree.inOrder(root);
            Tree.postOrder(root);

        }

}