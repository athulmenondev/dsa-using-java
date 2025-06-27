package Graphs;

import java.util.ArrayList;

public class Graph {
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
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        // graph[1].add(new Edge(1,4));

        // graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

       
        graph[3].add(new Edge(3, 2));
         graph[3].add(new Edge(3,5 ));
        
        graph[4].add(new Edge(4,0));
        // graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));

    }
    public  static ArrayList<Integer> findNeib(ArrayList<Edge> graph[],int idx){
        ArrayList<Integer> l=new ArrayList<>();
        for (int i = 0; i <=graph[idx].size()-1; i++) {
            l.add(graph[idx].get(i).dest);
        }
        return l;
    }
    public static boolean isCyclicUndirected(ArrayList<Edge> graph[],boolean visited[],int curr,int par){
        System.out.println("Entered function for "+ curr);
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            // System.out.println("loop for "+curr+ "when i ="+i);
            Edge e= graph[curr].get(i);
            // System.out.println("For "+curr+" dest "+e.dest);
            if(visited[e.dest]){
                if(e.dest!=par){
                    return true;
                }else{
                    continue;
                }
            }
            if (!visited[e.dest]) {
                if(isCyclicUndirected(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void disp(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Edge> l = graph[i];
            for (int j = 0; j < l.size(); j++) {
                Edge e= l.get(j);
                System.out.println("Edge between"+e.src+" and "+e.dest);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]= new ArrayList[v];
        createGraph(graph);
        // System.out.println(findNeib(graph, 2));
        System.out.println("graph created");
        System.out.println(isCyclicUndirected(graph, new boolean[v], 0, -1));
        // disp(graph);
    }

}
