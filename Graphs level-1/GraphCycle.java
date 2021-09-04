// 1. You are given a graph.
// 2. You are required to find and print if the graph is cyclic.

// Sample Input:
/* 

7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

*/

// Sample Output
// false

import java.io.*;
import java.util.*;

public class GraphCycle {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
     
     
     public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {
         
         // BFS Technique : r m* w a
         
         Queue<Integer> q = new LinkedList<>();
         q.add(src);
         
         while(q.size() > 0) {
             
             int v = q.poll();
             
             if(visited[v])
              return true;
              
             visited[v] = true;
             
             for(Edge e: graph[v])
              if(!visited[e.nbr])
                  q.add(e.nbr);
         }
         
         return false;
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
           graph[i] = new ArrayList<>();
        }
  
        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
           String[] parts = br.readLine().split(" ");
           int v1 = Integer.parseInt(parts[0]);
           int v2 = Integer.parseInt(parts[1]);
           int wt = Integer.parseInt(parts[2]);
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
        }
  
        // write your code here
        
        boolean[] visited = new boolean[vtces];
        for(int v = 0; v < vtces; v++){
            if(!visited[v]) {
                if(isCyclic(graph, v, visited)){
                    System.out.println(true);
                    return;
                }
            }
        }
        
        System.out.println(false);
       
     }
}
