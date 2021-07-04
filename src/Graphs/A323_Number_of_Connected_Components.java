package Graphs;

import java.util.ArrayList;
import java.util.List;

public class A323_Number_of_Connected_Components {// in an undirected graph


   public static Node[] makeConnectedGraphFromEdgeList(int numberOfNodes, int [][] edges){
      Node[] nodeArray = new Node[numberOfNodes];
      for(int i=0; i < numberOfNodes;i++)
         nodeArray[i] = new Node(i);
      for(int[] edge: edges){
         Node node1 = nodeArray[edge[0]];
         Node node2 = nodeArray[edge[1]];
         node1.neighbors.add(node2);
         node2.neighbors.add(node1);
      }
      return nodeArray;
   }


   public static int countComponents(int n, int[][] edges) {
      Node[] nodes = makeConnectedGraphFromEdgeList(n,edges);
      int components = 0;
      for (Node node: nodes) {
         if(!node.visited) {
            components++;
            dfs(node);
         }
      }
      return components;
   }

   public static void dfs(Node node){
      node.visited = true;
      for(Node child: node.neighbors){
         if (!child.visited)
            dfs(child);
      }
   }

   public static void main(String[] args){
      int result = countComponents(5,new int[][]{{0,1},{0,2},{0,3},{1,4}});
      System.out.println(result);
   }

   public static class Node {
      public int val;
      public List<Node> neighbors;
      boolean visited;

      public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<Node>();
      }
   }

}

