class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedListPalindrome {
    Node head;
    LinkedListPalindrome(){
        head=null;
   }
   public void add(int data){
        Node newNode = new Node(data);
        newNode.next=null;
        if (head==null) {
            head=newNode;
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
    public Node reverseRecursive(Node head){
        if(head.next==null || head==null) return head;
        Node newNode=reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    public boolean checkPalindrome(Node head){
        //to find number
        Node currentNode=head;
        Node last;
        int size=0;
        while (currentNode!=null) {
            size++;
            currentNode=currentNode.next;
        }
        if(size%2==0){
            int i=1;
            currentNode=head;
            while(i<=(size/2)) {
                i++;
                currentNode=currentNode.next;
            }
            last=reverseRecursive(currentNode);
        }else{
            int i=1;
            currentNode=head;
            while(i<=(size/2)+1){
                i++;
                currentNode=currentNode.next;
            }
            last=reverseRecursive(currentNode);
        }
        //boolean flag=true;
        int i=1;
        Node f=head,l=last;

        while(i<(size/2)){
            //
            //System.out.println("first="+f.data);
            //System.out.println("last="+ l.data);
            //
            if(f.data!=l.data){
                return false;
            }
            f=f.next;
            l=l.next;
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedListPalindrome ll = new LinkedListPalindrome();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(1);
       // ll.add(1);
        ll.display(ll.head);
        //ll.display(ll.reverseRecursive(ll.head));
        System.out.println(ll.checkPalindrome(ll.head));

    }
}
