package Queue;

public class CircularQueue {
    public class Que {
        int arr[];
        int n;
        static int front = -1;
        static int rear = -1;
        Que(int n){
            this.n=n;
            arr = new int[n];  
        }
        public void enqueue(int data ){
            if((rear+1)%n == front){
                System.out.println("The Queue is full \n");
                return;
            }
            rear=(rear+1)%n;
            arr[rear]=data;
        }
        public int dequeue(){
            if(front ==-1){
                System.out.println("The Queue is empty");
                return -1;
            }else if(front== rear){
                int data=arr[front];
                front=-1;
                rear=-1;
                return data;
            }else{
                int data=arr[front];
                front=(front+1)%n;
                return data;
            }

        }
    }
    
}
