package Queue;
//using O(n) for push
public class QueueUsingStack1 {
    public static  class St {
        static int s1[];
        static int s2[];
        static int t1,t2;
        St(){
            s1 = new int[10];
            s2 = new int[10];
            t1=t2=-1;
        }
        //pushS1
        public static void pushS1(int data){
            //fullcondition
            s1[++t1]=data;
            return;
        }
        //pushS2
        public static void pushS2(int data){
            //fullcondition
            s2[++t2]=data;
            return;
        }
        //pop
        public static int popS1(){
            if (t1==-1) {
                System.out.println("Queue empty");
                return -2;
            }
            int data= s1[t1--];
            return data;
        }
        //popS2
        public static int popS2(){
            if (t2==-1) {
                System.out.println("Queue empty");
                return -2;
            }
            int data= s2[t2--];
            return data;
        }
        public  void enqueue(int data){
            if(t1==-1){
                pushS1(data);
                return;
            }
            while (t1!=-1) {
                pushS2(popS1());
            }
            pushS1(data);
            while (t2!=-1) {
                pushS1(popS2());
            }
        }
        public int dequeue(){
            return popS1();
        }
        public boolean isEmpty(){
            if(t1!=-1) return false;
            else 
            return true;
        }
        public void display(){
            int t=t1;
            while (t!=-1) {
                System.out.println(s1[t--]);
            }
        }
    }
    public static void main(String[] args) {
        St ll = new St();
        ll.enqueue(5);
        ll.enqueue(6);
        ll.enqueue(7);
        ll.display();
    }
}
