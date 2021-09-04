// 1. You are given a graph, representing people and their connectivity.
// 2. You are also given a src person (who got infected) and time t.
// 3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.

// Sample Input
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
6
3

 */

// Sample Output
// 4

import java.io.*;
import java.util.*;

public class InfectionSpread {
    static class Edge {
        int src;
        int nbr;
  
        Edge(int src, int nbr) {
           this.src = src;
           this.nbr = nbr;
        }
     }
     
     static class Pair {
         int v;
         int level;
         
         Pair(int v, int level) {
             this.v = v;
             this.level = level;
         }
     }
     
     public static void infectionSpread(ArrayList<Edge>[] graph, int src, int[] visited) {
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(src, 1));
         
         while(q.size() > 0) {
             
             Pair rem = q.poll();
             
             if(visited[rem.v] == -1)
               visited[rem.v] = rem.level;
             
             for(Edge e: graph[rem.v]) {
                 if(visited[e.nbr] == -1)
                  q.add(new Pair(e.nbr, rem.level+1));
             }
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
        int t = Integer.parseInt(br.readLine());
        
        // write your code here
        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        
        infectionSpread(graph, src, visited);
        
        int ans = 0;
        for(int num: visited)
          if(num != -1 && num <= t)
              ans += 1;
        
        
       System.out.println(ans);
     }
}
