package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class WeightedGraph2 {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

        // graph[4].add(new Edge(4, 5));
    }
//kosaraju

//topsort
public static void topSort(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> s){
    visited[curr]=true;
    for (int i  = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if(!visited[e.dest]){
            topSort(graph, visited, e.dest, s);
        }
    }
    s.push(curr);
}
//dfs
public static void dfs(ArrayList<Edge> graph[],boolean visited[],int curr){
    visited[curr]=true;
    System.out.print(curr);
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if(!visited[e.dest]){
            dfs(graph, visited, e.dest);
        }
    }

}
public static void kosarajuAlgo(ArrayList<Edge> graph[],boolean visited[],int V){
    // step1
    Stack<Integer> s= new Stack<>();
    for (int i = 0; i  < V; i ++) {
        if (!visited[i]) {
            topSort(graph, visited, i, s);  
        }
    }

    //step2
    ArrayList<Edge> transpose[] = new ArrayList[V];
    for (int i = 0; i < V;i++) {
        transpose[i]= new ArrayList<>();
        visited[i]=false;
    }
    for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e= graph[i].get(j);
            transpose[e.dest].add(new Edge(e.dest, e.src));
        }
    }


    //step3
    for (int i = 0; i < transpose.length; i++) {
            if (!visited[i]) {
                dfs(transpose,visited,i);
                System.out.println();
            }
    }

}
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraph(graph);
        kosarajuAlgo(graph, new boolean[v], v);
    }
}
