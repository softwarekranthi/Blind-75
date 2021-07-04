package Graphs;

import java.util.*;

public class Clone_Graph {

   public static Node cloneGraph(Node node){
      if (node==null)
         return null;
      HashMap<Node,Node> oldToNew = new HashMap<Node,Node>();
      runDFSAndCreateNewNodes(node,oldToNew);
      return oldToNew.get(node);
   }

   public static void runDFSAndCreateNewNodes(Node node, HashMap<Node, Node> oldToNew){
      Node newNode = new Node(node.val);//create a newNode for old node
      oldToNew.put(node, newNode);//make the key value pair, even before going to neighbours so you will have instances available to access
      ArrayList<Node> neighbours = new ArrayList<Node>();//add neighbours to the newNode based on oldNode
      for (Node neighbour: node.neighbors) {
         if (!oldToNew.keySet().contains(neighbour))
            runDFSAndCreateNewNodes(neighbour, oldToNew);
         neighbours.add(oldToNew.get(neighbour));//You have to always fetch the node instance from the Hasmap but not create it
      }
      newNode.neighbors = neighbours;
   }


   public static void main(String[] args){
      int[] values = new int[]{1,2,3,4};
      int[][] adjacencyList = new int[][]{{1,3},{0,2},{1,3},{0,2}};
      Node graph1  = Node.makeConnectedGraphFromAdjacencyList(values,adjacencyList);
      Node graph2 = cloneGraph(graph1);
      System.out.println("dfdf");

   }
}
