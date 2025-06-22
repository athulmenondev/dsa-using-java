//package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

class HashMapCode {
    public static class HashMap<K,V> {
        public class Node {
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }

        int N;
        int n;
        LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        HashMap(){
            this.N=4;
            this.buckets =new LinkedList[4];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<Node>();
            }
        }

        public int hashFunction(K key){
            int bi =key.hashCode();
            return  (Math.abs(bi))%N;
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll= buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[]=buckets;
            buckets= new LinkedList[N*4];
            for (int i = 0; i < N*2; i++) {
                buckets[i]=new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll= oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    put(ll.get(j).key, ll.get(j).value);
                }
            }
        }
        
        public void put(K key, V value){
            int bi=hashFunction(key);
            int di=searchInLL(key,bi);
            if(di==-1){
                n++;
                buckets[bi].add(new Node(key, value));
            }else{
                Node curNode= buckets[bi].get(di);
                curNode.value=value;
            }
            double lamda=(double)n/N;
            if(lamda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
                return false;
            }else{
                return true;
            }
        }
        public V remove(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
                return null;
            }else{
                Node node=buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public V get(K key){
            int bi=hashFunction(key);
            int di=searchInLL(key, bi);
            if(di==-1){
                return null;
            }else{
                Node node=buckets[bi].get(di);
                return node.value;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys= new ArrayList<>(); 
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll=buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    keys.add(ll.get(j).key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        HashMap<String,Integer> map= new HashMap<>();
        map.put("India", 230);
        map.put("China", 150);
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        System.out.println("removing India value="+map.remove("India"));
        System.out.println(map.get("India"));
    }    
}