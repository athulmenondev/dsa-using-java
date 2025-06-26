package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WeightedGraph {
    static class Edge {
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

    graph[0].add(new Edge(0, 1));
    //graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));
    // graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));
    graph[2].add(new Edge(2, 0));
    //graph[2].add(new Edge(2, 1));
    //graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));
    //graph[4].add(new Edge(4, 3));
        
    }
    public  static ArrayList<Integer> findNeib(ArrayList<Edge> graph[],int idx){
        ArrayList<Integer> l=new ArrayList<>();
        for (int i = 0; i <=graph[idx].size()-1; i++) {
            l.add(graph[idx].get(i).dest);
        }
        return l;
    }
    //BFS 
    public static void bfs(ArrayList<Edge> graph[],int start,boolean visited[]){
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while (!q.isEmpty()) {
            int current=q.remove();
            System.out.println(current);
            for (int i = 0; i <graph[current].size(); i++) {
                if (!visited[graph[current].get(i).dest]) {
                    q.add(graph[current].get(i).dest);
                    visited[graph[current].get(i).dest]=true;
                }
            }
        }
    }
    //DFS
    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int curr){
        System.out.println(curr);
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            if(!visited[graph[curr].get(i).dest]){
                dfs(graph, visited, graph[curr].get(i).dest);
            }
        }
    }
    public static void findAllPaths(ArrayList<Edge> graph[],boolean visited[],String path,int curr,int tar){
        if (curr==tar) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if (!visited[e.dest]) {
                visited[curr]=true;
                findAllPaths(graph, visited, path+e.dest, e.dest, tar);
                visited[curr]=false;
            }
        }
    }
    public static boolean isCycle(ArrayList<Edge> graph[],boolean visited[],boolean recursiostack[],int curr){
        visited[curr]=true;
        recursiostack[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if(recursiostack[e.dest]){
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycle(graph, visited, recursiostack, e.dest)){
                    return true;
                }
            }
        }
        recursiostack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
         int v=7;
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraph(graph);
        boolean[] visited=new boolean[graph.length];
        //BFS
        // for (int i = 0; i < graph.length; i++) {
        //     if(!visited[i]){
        //         bfs(graph,i,visited);
        //     }
        // }

        //DFS
        // for (int i = 0; i < graph.length; i++) {
        //     if(!visited[i]){
        //        dfs(graph,visited,i);;
        //     }
        // }
        
        //findallpaths
        //findAllPaths(graph, visited, "0", 0, 5);
        
        System.out.println(isCycle(graph, visited, new boolean[v],0));
    }
}
