package org.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A_BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int node = q.remove();
            bfs.add(node);
            for(Integer neighbours : adj.get(node)){
                if(!vis[neighbours]){
                    q.add(neighbours);
                    vis[neighbours]=true;
                }
            }
        }
        return bfs;
    }
}
