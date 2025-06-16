 class Node {
    
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LL {
    Node head;
    LL(){
        head=null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        newNode.next=null;
        if (head==null) {
            head=newNode;
            newNode.next=null;
            return;
        }
        Node curentNode =head;
        while(curentNode.next!=null){
            curentNode=curentNode.next;
        }
        curentNode.next=newNode;
    }
    public void display(Node head){
        if (head==null) {
            System.out.println("NULL");
        }else{
            Node currNode = head;
            while (currNode!=null) {
                System.out.print(currNode.data+"--->");
                currNode=currNode.next;
            }
            System.out.println("NULL");
        }
    }
    public Node reverseIterative(Node head){
        if(head==null || head.next==null) return null;
        Node currNode,prevNode,nextNode;
        prevNode=null;
        currNode=head;
        while(currNode!=null){
            nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
            
        }
       return prevNode;
    }
    public Node reverseRecursive(Node head){
        if(head==null || head.next==null) return head;
        Node newhead = reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }

    public static void main(String[] args) {
        LL ll=new LL();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        System.out.println("Original list");
        ll.display(ll.head);
        // System.out.println("Recursive");
        // ll.display(ll.reverseRecursive(ll.head));
        System.out.println("Iterative");
        ll.display(ll.reverseIterative(ll.head));
    }
    
}