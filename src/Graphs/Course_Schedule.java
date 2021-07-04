package Graphs;

import java.util.LinkedList;
import java.util.List;

public class Course_Schedule {

   public static boolean canFinish(int numCourses, int[][] prerequisites) {
      CNode[] nodes = createDirectedGraphFromEdgeList(numCourses, prerequisites);
      addPreAndPostNumbers(nodes);
      for (int[] edge: prerequisites){
         CNode originNode = nodes[edge[1]];//node
         CNode destinationNode = nodes[edge[0]];
         if(destinationNode.post>=originNode.post)
            return false;
      }
      return true;
   }

   public static CNode[] createDirectedGraphFromEdgeList(int numCourses, int[][] edgeList ){
      CNode[] nodes = new CNode[numCourses];
      for (int i=0; i< numCourses; i++){
         nodes[i] = new CNode(i);
      }
      for (int[] edge: edgeList){
         CNode originNode = nodes[edge[1]];//node
         CNode destinationNode = nodes[edge[0]];
         originNode.neighbors.add(destinationNode);
      }
      return nodes;//Graph need not be connected, Hence we cant use graph by first node alone
   }


   public static void addPreAndPostNumbers(CNode[] nodes){
      MutableInteger counter = new MutableInteger(1);
      for (CNode node: nodes){
         if(!node.visited)
            DFS(node,counter);
      }
   }

   public static void DFS(CNode node, MutableInteger counter){
      node.pre = counter.value;
      counter.value = counter.value +1;
      node.visited = true;
      for (CNode neighbour: node.neighbors) {
         if(!neighbour.visited)
            DFS(neighbour, counter);
      }
      node.post = counter.value;
      counter.value = counter.value +1;
   }


   public static void main(String [] args){
      int[][] edgeList1 = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
      int numEdges1 = 20;
      int[][] edgeList2 = {{1,0},{0,1}};
      int numEdges2 = 2;
      int[][] edgeList3 = {{0,1}};
      int numEdges3 = 2;

//      boolean result = canFinish(numEdges1, edgeList1);
//      boolean result = canFinish(numEdges2, edgeList2);
      boolean result = canFinish(numEdges3, edgeList3);
      System.out.println(result);
   }

   private static class CNode {
      public int index;
      public List<CNode> neighbors;
      boolean visited;
      public int pre;
      public int post;

      public CNode() {
         index = 0;
         neighbors = new LinkedList<CNode>();
      }

      public CNode(int _val) {
         index = index;
         neighbors = new LinkedList<CNode>();
      }

   }

   public static class MutableInteger {
      public int value;
      public MutableInteger(int value) {
         this.value = value;
      }
   }

}
