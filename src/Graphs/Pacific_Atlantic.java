package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Pacific_Atlantic {


   public static List<List<Integer>> pacificAtlantic(int[][] heights) {
      int numRows = heights.length;
      int numColumns = heights[0].length;
      WNode[][] islandGrid = new WNode[numRows][numColumns];
      WNode pacific = new WNode();
      WNode atlantic = new WNode();
      setupInterGridEdges(islandGrid, heights);
      setupPacificAndAtlanticEdges(islandGrid,pacific,atlantic);
      runDFSPacific(pacific);
      runDFSAtlantic(atlantic);

      List<List<Integer>> result = new ArrayList<>();
      for (int i=0; i< numRows; i++){
         for (int j=0; j<numColumns; j++){
            if(islandGrid[i][j].visitedAtlantic && islandGrid[i][j].visitedPacific) {
               ArrayList coordinate = new ArrayList();
               coordinate.add(i);
               coordinate.add(j);
               result.add(coordinate);
            }
         }
      }
      return result;
   }

   public static void setupPacificAndAtlanticEdges(WNode[][] islandGrid, WNode pacific, WNode atlantic){
      int numRows = islandGrid.length;
      int numColumns = islandGrid[0].length;
      for (int i=0; i< numRows; i++)
         pacific.neighbors.add(islandGrid[i][0]);
      for (int i=1; i< numColumns; i++)
         pacific.neighbors.add(islandGrid[0][i]);
      for (int i=0; i< numRows; i++)
         atlantic.neighbors.add(islandGrid[i][numColumns-1]);
      for (int i=0; i< numColumns-1; i++)
         atlantic.neighbors.add(islandGrid[numRows-1][i]);

   }

   public static void setupInterGridEdges(WNode[][] islandGrid, int[][] heights){
      int numRows = islandGrid.length;
      int numColumns = islandGrid[0].length;
      for (int i=0; i< numRows; i++){
         for (int j=0; j<numColumns; j++) {
            islandGrid[i][j] = new WNode(i,j);
         }
      }
      for (int i=0; i< numRows; i++){
         for (int j=0; j<numColumns; j++){
            if(i>=1) {
               if(heights[i][j] <= heights[i - 1][j])
                  islandGrid[i][j].neighbors.add(islandGrid[i-1][j]);
            }
            if(j>=1) {
               if(heights[i][j] <= heights[i][j-1])
                  islandGrid[i][j].neighbors.add(islandGrid[i][j-1]);
            }
            if(i<=numRows-2) {
               if(heights[i][j] <= heights[i+1][j])
                  islandGrid[i][j].neighbors.add(islandGrid[i+1][j]);
            }
            if(j<=numColumns-2) {
               if(heights[i][j] <= heights[i][j+1])
                  islandGrid[i][j].neighbors.add(islandGrid[i][j+1]);
            }
         }
      }
   }

   public static void runDFSPacific(WNode node){
      node.visitedPacific = true;
      for (WNode neighbour: node.neighbors) {
         if(!neighbour.visitedPacific) runDFSPacific(neighbour);
      }
   }

   public static void runDFSAtlantic(WNode node){
      node.visitedAtlantic = true;
      for (WNode neighbour: node.neighbors) {
         if(!neighbour.visitedAtlantic) runDFSAtlantic(neighbour);
      }
   }



   public static void main(String [] args){
      int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//      int[][] heights = {{2,1},{1,2}};
//      int[][] heights = {{1,1},{1,1},{1,1}};
//      int[][] heights = {{1,2,3},{8,9,4},{7,6,5}};
      List<List<Integer>> cells = pacificAtlantic(heights);
      System.out.println(cells);
   }

   public static class WNode {
      public int row;
      public int column;
      public List<WNode> neighbors;
      boolean visitedPacific;
      boolean visitedAtlantic;

      public WNode() {
         row   = -1;
         column = -1;
         neighbors = new LinkedList<WNode>();
      }
      public WNode(int _row, int _column){
         row = _row;
         column = _column;
         neighbors = new LinkedList<WNode>();
      }



   }

}
