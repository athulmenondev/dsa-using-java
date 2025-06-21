package BST;

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
    }
    public static void main(String[] args) {
        int Values[]={5,1,7,6,8,3,9};
        Node root=null;
        for (int i = 0; i < Values.length; i++) {
           root=Node.buildTree(Values[i],root);
        }
        Node.inOrder(root);
        //System.out.println(Node.searchBst(root,2));
        root=Node.deleteNode(root,8);
        System.out.print("\n");
        Node.inOrder(root);
    }
}
