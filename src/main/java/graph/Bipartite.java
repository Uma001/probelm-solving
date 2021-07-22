package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* Instead of visited array, use color array,
* and check if color array is already set then the colour should be equal to the parent's color
* */
public class Bipartite {

    public static void main(String[] args) {
        int n=5;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(1).add(4);
        adj.get(4).add(1);


        System.out.println(isBipartiteBFS(adj, 5));

        int[] colour=new int[5];
        for(int i=0;i<colour.length;i++){
            colour[i]=-1;
        }
        System.out.println(isBipartiteDFS(adj,0,colour));
    }

    private static boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> adj, int V) {

        int[] visited=new int[V];
        Arrays.fill(visited,-1);

        Integer root = adj.get(0).get(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited[root]=0;

        while(!q.isEmpty()){
            Integer parent=q.poll();

            for(Integer child: adj.get(parent)){
                if(visited[child]==-1){//if its not coloured
                    visited[child]=visited[parent]==0?1:0;
                    q.add(child);
                } else if(visited[child]==visited[parent]){
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isBipartiteDFS(ArrayList<ArrayList<Integer>> adj,int parent, int[] colour) {

        if(colour[parent]==-1){
            colour[parent]=0;
        }

        for(Integer child: adj.get(parent)){
            if(colour[child]!=-1){

                colour[child]=1-colour[parent];

                isBipartiteDFS(adj,child,colour);
            }else if(colour[child]==colour[parent]){
                return false;
            }
        }

        return true;


    }
}
