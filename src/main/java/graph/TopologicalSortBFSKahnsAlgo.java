package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFSKahnsAlgo {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=5;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(3).add(2);
        adj.get(4).add(2);

        for(int node:topologicalSort(adj,n)){
            System.out.print(node+" ");
        }
    }

    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj,int  V) {
//        boolean[] visited=new boolean[V];
        int[] inDegree=new int[V];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> sorted=new ArrayList<>();
        //build in degree
        for(int i=0;i<V;i++){
            for(int connectn: adj.get(i)){
                inDegree[connectn]++;
            }
        }

        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int node=q.poll();
            sorted.add(node);
//            visited[node]=true;
            for(int child: adj.get(node)){
//                if(!visited[child]){
                    inDegree[child]--;
//                }
                if(inDegree[child]==0){
                    q.add(child);
                }
            }

        }

        return sorted;
    }
}
