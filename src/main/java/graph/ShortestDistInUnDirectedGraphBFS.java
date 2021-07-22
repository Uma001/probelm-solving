package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
*
* find shortest distance in undirected graph
* consider weight as 1 for each node
* */
public class ShortestDistInUnDirectedGraphBFS {

    public static void main(String[] args) {
        int n=7;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(3).add(6);
        adj.get(6).add(3);

        int i=0;
        for(int dist:findShortestDist(adj, n)){
            System.out.print(i+":"+dist+" ");
            i++;
        }



    }

    private static int[] findShortestDist(ArrayList<ArrayList<Integer>> adj,int V) {

        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()){
            Integer source= q.poll();

            for(int child:adj.get(source)){

                if(dist[source]+1<dist[child]){
                    dist[child]=dist[source]+1;
                    q.add(child);
                }
            }
        }


        return dist;

    }

}
