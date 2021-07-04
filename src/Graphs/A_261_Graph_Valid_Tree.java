package Graphs;

import java.util.ArrayList;
import java.util.List;

public class A_261_Graph_Valid_Tree {

   public static Node makeConnectedGraphFromEdgeList(int numberOfNodes, int [][] edges){
      Node[] nodeArray = new Node[numberOfNodes];
      for(int i=0; i < numberOfNodes;i++)
         nodeArray[i] = new Node(i);
      for(int[] edge: edges){
         Node node1 = nodeArray[edge[0]];
         Node node2 = nodeArray[edge[1]];
         node1.neighbors.add(node2);
         node2.neighbors.add(node1);
      }
      return nodeArray[0];
   }


   public static boolean validTree(int n, int[][] edges) {
      if(n-1!= edges.length)
         return false;
      Node start = makeConnectedGraphFromEdgeList(n,edges);
      MutableInteger nodeCounter = new MutableInteger(0);
      dfs(start, nodeCounter);
      return nodeCounter.value == edges.length+1;
   }



   public static void dfs(Node node, MutableInteger counter){
      node.visited = true;
      counter.value = counter.value+1;
      for(Node child: node.neighbors){
         if (!child.visited)
            dfs(child,counter);
      }
   }

   public static void main(String[] args){
      boolean result = validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,4}});
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

   public static class MutableInteger {
      public int value;
      public MutableInteger(int value) {
         this.value = value;
      }
   }
}
