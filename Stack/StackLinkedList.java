package Stack;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class StackLinkedList {
    Node head;
    StackLinkedList(){
        head=null;
    }
    boolean isEmpty(Node head){
        return( head==null);
    }
    public void push(int data){
        Node newNode= new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public int pop(){
        if(isEmpty(head)){
            System.out.println("the stack is emplty");
            return -1;
        }
        int data =head.data;
        head=head.next;
        return data;
    }
    public int peek(){
        if(isEmpty(head)) return -1;
        return head.data;
    }
    public static void main(String[] args) {
        StackLinkedList ll= new StackLinkedList();
        Scanner sc = new Scanner(System.in);
        int ch;
        int data;
        for(int i=0;i<5;i++){
            System.out.println("1.push   2.pop    3.peek\n");
            ch=sc.nextInt();
            switch (ch) {
                case 1:
                    data=sc.nextInt();
                    ll.push(data);
                    break;
                case 2 : System.out.println(ll.pop());
                    break;
                case 3 : System.out.println(ll.peek());
            }
        }
        sc.close();
    }
}
