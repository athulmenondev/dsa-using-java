package Stack;
import java.util.Stack;

public class StackReverse {
    public static void insertAtBottom(int data,Stack<Integer> ll){
        if(ll.isEmpty()){
            ll.push(data);
            return;
        }
        int top=ll.pop();
        insertAtBottom(data,ll);
        ll.push(top);
        return;
    }
    public static void stackReverse(Stack<Integer> ll){
        if(ll.isEmpty()){
            return;
        }
        int top = ll.pop();
        stackReverse(ll);
        insertAtBottom(top, ll);
        return;
    }
    public static void main(String[] args) {
        Stack<Integer> ll=new Stack<>();
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        stackReverse(ll);
        while(!ll.isEmpty()){
            System.out.println(ll.pop());
        }
    }
}
