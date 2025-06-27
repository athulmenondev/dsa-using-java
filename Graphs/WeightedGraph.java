package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class WeightedGraph {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2 ));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2,1 ));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4,3 ));

        graph[3].add(new Edge(3, 5,1 ));

        graph[4].add(new Edge(4, 3,2 ));
        graph[4].add(new Edge(4, 5,5 ));

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
    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean visited[],boolean recursiostack[],int curr){
        visited[curr]=true;
        recursiostack[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e= graph[curr].get(i);
            if(recursiostack[e.dest]){
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycleDirected(graph, visited, recursiostack, e.dest)){
                    return true;
                }
            }
        }
        recursiostack[curr]=false;
        return false;
    }

    //topological order
    public static void  topologicalOrder(ArrayList<Edge> graph[],boolean visited[],Stack<Integer> st,int curr){
        System.out.println("Entered function for "+ curr);
        visited[curr]=true;
        for (int index = 0; index < graph[curr].size(); index++) {
            Edge e= graph[curr].get(index);
            if(!visited[e.dest]){
                topologicalOrder(graph, visited, st, e.dest);
            }
        }
        System.out.println("pushing to stack "+ curr);
        st.push(curr);
    }

    //dijiksthras
    public static class Pair implements Comparable<Pair>{
        int v;
        int dist;
        public Pair(int v, int dist){
            this.dist=dist;
            this.v=v;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist=dist;
        }
    }
    static PriorityQueue<Pair> q= new PriorityQueue<>();

    public static void dijksthras(ArrayList<Edge> graph[],int source,int v){
        boolean visited[] = new boolean[v];
        int dist[]= new int[v];
        for (int i = 0; i < dist.length; i++) {
            if (i==source) {
                dist[i]=0;
                continue;
            }
            dist[i]=Integer.MAX_VALUE;
        }
        q.add(new Pair(source, 0));
        Pair p;
        while (!q.isEmpty()) {
            p=q.remove();
            for (int i = 0; i < graph[p.v].size(); i++) {
                Edge e= graph[p.v].get(i);
                if (!visited[e.dest]) {
                    if(dist[p.v]+e.wt<dist[e.dest]){
                        dist[e.dest]=dist[p.v]+e.wt;
                    }
                    q.add(new Pair(e.dest, dist[e.dest]));
                }
            }

        }
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
    }

    

    public static void main(String[] args) {
         int v=6;
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
        
        //CycleExistsDirected
        // for (int i = 0; i < v; i++) {
            // if(isCycleDirected(graph, visited, new boolean[v],0)){
        //         System.out.println(true);
        //         break;
        //     }
        // }

        //topological sort
        // Stack<Integer> st=new Stack<>();
        // for (int i = 0; i < v; i++) {
        //     System.out.println("calling function for "+i);
        //     if(!visited[i]){
        //         topologicalOrder(graph, visited, st, i);
        //     }
        // }
        // for (int index = 0; index < v; index++) {
        //     System.out.println(st.pop());
        // }

        //dijiksthras
        dijksthras(graph, 0, v);
    }
}
