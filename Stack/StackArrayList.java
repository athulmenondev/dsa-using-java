package Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class StackArrayList {
    ArrayList<Integer> ll=new ArrayList<>();
    public boolean isEmpty() {return ll.size()==0;}
    public void push(int data){
        ll.add(data);
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int data = ll.get(ll.size()-1);
        ll.remove(ll.size()-1);
        return data;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return(ll.get(ll.size()-1));
    }
    public static void main(String[] args) {
        StackArrayList ll = new StackArrayList();
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
