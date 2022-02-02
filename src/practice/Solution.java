package practice;
import java.util.*;
public class Solution {
    static int bellmonFord(int v, int e, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      // Write your code here.
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++){
			graph.add(new ArrayList<>());
            
        }
        for(int i = 0; i < e; i++){
            graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
//             graph.get(edges.get(i).get(1)).add(new Node(edges.get(i).get(0), edges.get(i).get(2)));
            

		}

        int[] dist = new int[v + 1];
        Arrays.fill(dist, 1000000000);
        dist[src] = 0;
        for(int j = 1; j <= v; j++){
            for(int i = 0; i < e; i++){
                int u = edges.get(i).get(0);
                int vt = edges.get(i).get(1);
                int wt = edges.get(i).get(2);
                
                
                if(dist[u] + wt < dist[vt]){
                    dist[vt] = dist[u] + wt;
                }
            }
        }
        boolean visited[] = new boolean[v + 1];
        boolean ans = checkPath(src, dest, graph, visited);
        return ans ? dist[dest] : (int)1e9;
    }
    



    public static boolean checkPath(int src, int dest, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        if(src == dest) return true;
        
        visited[src] = true;
        for(int nbr : graph.get(src)){
            if(!visited[src]){
                if(checkPath(nbr, dest, graph, visited)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}

