// 1. You are given a graph, and a src vertex.
// 2. You are required to do a breadth first traversal and print which vertex is reached via which path, starting from the src.

// Sample Input:
/* 

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

 */

// Sample Output:
/* 
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

 */
import java.io.*;
import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
     static class Pair{
         
         int cur;
         String path;
         
         Pair(int cur, String path){
             this.cur = cur;
             this.path = path;
         }
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
           graph[v1].add(new Edge(v1, v2));
           graph[v2].add(new Edge(v2, v1));
        }
  
        int src = Integer.parseInt(br.readLine());
  
        // write your code here  
        boolean[] visited = new boolean[vtces];
        Queue<Pair> q = new LinkedList<>();
        visited[src] = true;
        q.add(new Pair(src, ""+src));
        
        while(q.size() > 0){
            Pair p = q.poll();
            
            System.out.println(p.cur + "@" + p.path);
            
            for(Edge e: graph[p.cur])
              if(!visited[e.nbr]){
                  visited[e.nbr] = true;
                  q.add(new Pair(e.nbr, p.path+e.nbr));
              }
        }
     }
}
