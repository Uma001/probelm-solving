package graph;

import java.util.ArrayList;
import java.util.Stack;

/*
* DAG
* when dfs call for any node is over, put it into stack
* */
public class TopologicalSortDFS {

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

        boolean[] visited=new boolean[n];
        for(int node: topologicalSort(adj,n, visited)){
            System.out.print(node+" ");
        }
    }

    private static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int size, boolean[] visited){

        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<size;i++){

            if(!visited[i]){
                dfs(adj,i,visited,stack);
            }
        }

        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> stack) {

        visited[i]=true;

        for(int child:adj.get(i)){
            if(!visited[child]){
                dfs(adj,child,visited,stack);
            }
        }
        stack.add(i);
    }
}
