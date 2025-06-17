package Queue;

public class QueueArray {

    public static class Qu{
        static int arr[];
         int size;
        static int rear=-1;
        Qu(int n){
            this.size=n;
            arr = new int[size];
        }
        public void enqueue(int data){
            if(rear==size-1) {
            System.out.println("Enqueue: the Queue is full"); 
            return ;
            }
            arr[++rear]=data;
            System.out.println("Enqueue"+data+" is added , rear is " + rear);
            return;
        }
        public  int dequeue(){
            if(rear==-1){
                System.out.println("Dequeue:Queue is empty");
                return -1;
            }
            int data = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i]=arr[i+1];
            }
            rear--;
            System.out.println("Dequeue: "+data+" is removed");
            return data;
        }
        public static int peek(){
            if(rear==-1){
                System.out.println("Peek: Queue is empty");
                return -1;
            }
            System.out.println("peek: "+ arr[0]);
            return arr[0];
        }
        public void display(){
            System.out.println("Display: The queue is");
            if(rear==-1) {
                System.out.println("display queue is empty");
                return ;
            }
            for (int i = 0; i <=rear; i++) {
                    System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args) {
        Qu q = new Qu(10);
        q.enqueue(1);
        q.enqueue(0);
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
    }
}