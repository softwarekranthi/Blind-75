package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
   public int val;
   public List<Node> neighbors;
   boolean visited;//these flags are use and throw i.e. only one algorithm could be run using them.
   // After that we need to reset flags by traversing graph without using these flags

   public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
   }
   public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
   }
   public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
   }

   public static Node makeConnectedGraphFromAdjacencyList(int[] values,int [][] adjacencyList){
      //adjacency list contains matrices of node numbers
      Node[] nodeArray = new Node[adjacencyList.length];
      for(int i=0; i < adjacencyList.length;i++)
         nodeArray[i] = new Node(values[i]);
      for(int i=0; i < adjacencyList.length;i++){
         ArrayList<Node> neighbours = new ArrayList<>(adjacencyList[i].length);
         for(int j=0; j < adjacencyList[i].length;j++){
            int nodeNumber = adjacencyList[i][j];
            neighbours.add(nodeArray[nodeNumber]);
         }
         nodeArray[i].neighbors = neighbours;
      }
      return nodeArray[0];
   }


}
