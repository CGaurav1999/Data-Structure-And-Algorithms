package org.dsa.graph;

import java.util.ArrayList;

public class C_NumberOfProvinces {
    public static void dfs_helper(int node,boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        ArrayList<Integer> neighbours = adj.get(node);
        for(int i=0;i<neighbours.size();i++){
            if(neighbours.get(i)==1 && !vis[i]){
                dfs_helper(i,vis,adj);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean []vis = new boolean[V];
        int provinces = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs_helper(i,vis,adj);
                provinces++;
            }
        }
        return provinces;
    }
}
