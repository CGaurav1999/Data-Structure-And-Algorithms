package org.dsa.graph;

import java.util.ArrayList;

public class B_DFSTraversal {
    public void dfs_helper(int node, boolean[] vis, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        dfs.add(node);
        for(Integer neighbours : adj.get(node)){
            if(!vis[neighbours]){
                dfs_helper(neighbours,vis,dfs,adj);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []vis = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs_helper(0,vis,dfs,adj);
        return dfs;
    }
}
