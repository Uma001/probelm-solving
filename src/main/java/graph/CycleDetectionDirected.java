package graph;

import java.util.ArrayList;

public class CycleDetectionDirected {

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
//        adj.get(1).add(0);

        adj.get(1).add(2);
//        adj.get(2).add(1);

        adj.get(2).add(3);
//        adj.get(3).add(2);

        adj.get(3).add(4);
//        adj.get(4).add(3);

//        adj.get(1).add(4);
        adj.get(4).add(1);


        boolean[] visited=new boolean[n];
        boolean[] dfsVisited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(isCycle(adj,visited,dfsVisited,i)){
                    System.out.println(true);
                    break;
                }
            }
        }

    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited, int i) {

        visited[i]=true;
        dfsVisited[i]=true;

        for(int child:adj.get(i)){
            if(!visited[child]){
                if(isCycle(adj,visited,dfsVisited,child)) return true;
            }else if(dfsVisited[child]) {
                return true;
            }
        }

        dfsVisited[i]=false;
        return false;
    }



}
