package practice;
import java.util.*;


class DisjointSet{

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

	
		DisjointSet obj = new DisjointSet(); 
		obj.KruskalAlgo(adj, n);
    }

   

    private void KruskalAlgo(ArrayList<Node> adj, int n) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < rank.length; i++) {
            parent[i] = i;
            rank[i] = 0;

        }
        int mstCost = 0;
        Collections.sort(adj, new SortComparator());
        for(Node it : adj){
            int u = it.getU();
            int v = it.getV();
            u = findParent(u, parent);
            v = findParent(v, parent);
            if(u != v){
                mstCost += it.getWt();
                union(it.getU(), it.getV(), parent, rank);
            }
        }

        System.out.println(mstCost);


        

    }

    private int findParent(int u, int[] parent){
        if(u == parent[u]) return u;
        return parent[u] = findParent(parent[u], parent);
        
    }

    private void union(int u, int v, int[] parent, int[] rank){
        u = findParent(u, parent);
        v = findParent(v, parent);
        if(rank[u] < rank[v]){
            parent[u] = v;

        }else if(rank[u] > rank[v]){
            parent[v] = u;

        }else{
            parent[v] = u;
            rank[u]++;
        }

    }
}


class SortComparator implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getWt() < o2.getWt()) return -1;
        if(o1.getWt() > o2.getWt()) return 1;


        return 0;
    }

}


class Node{
    private int u;
    private int v;
    private int wt;
    Node(){};
    Node(int i, int j, int k){
        u = i;
        v = j;
        wt = k;
    }
    public int getU() {
        return u;
    }
    public void setU(int u) {
        this.u = u;
    }
    public int getV() {
        return v;
    }
    public void setV(int v) {
        this.v = v;
    }
    public int getWt() {
        return wt;
    }
    public void setWt(int wt) {
        this.wt = wt;
    }
    

}