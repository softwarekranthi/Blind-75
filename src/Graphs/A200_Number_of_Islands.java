package Graphs;


public class A200_Number_of_Islands {

   public static void dfs(char[][] grid, int r, int c) {
      int numRows = grid.length;
      int numColumns = grid[0].length;
      if (r < 0 || c < 0 || r >= numRows || c >= numColumns || grid[r][c] == '0') {
         return;
      }
      grid[r][c] = '0';
      dfs(grid, r - 1, c);
      dfs(grid, r + 1, c);
      dfs(grid, r, c - 1);
      dfs(grid, r, c + 1);
   }

   public static int numIslands2(char[][] grid) {//LeetCode Solution, He used gridchar== 0 as visited flag which greatly simplifies edge cases
      int numRows = grid.length;
      int numColumns = grid[0].length;
      int num_islands = 0;
      for (int r = 0; r < numRows; ++r) {
         for (int c = 0; c < numColumns; ++c) {
            if (grid[r][c] == '1') {
               ++num_islands;
               dfs(grid, r, c);
            }
         }
      }
      return num_islands;
   }


   public static int numIslands(char[][] grid) {
      int numRows = grid.length;
      int numColumns = grid[0].length;
      boolean[][] visited = new boolean[numRows][numColumns];
      int counter =0;
      for (int i=0; i< numRows; i++){
         for (int j=0; j< numColumns; j++){
            if(!visited[i][j] && grid[i][j]!='0' ){
               explore(grid, visited,i, j);
               counter++;
            }
         }
      }
      return counter;
   }

   public static void explore(char[][] grid, boolean[][] visited, int i, int j) {
      visited[i][j] = true;
      int numRows = grid.length;
      int numColumns = grid[0].length;
      if(grid[i][j]!='0') {
         if(0 <= i-1) {
            if (!visited[i - 1][j])
               explore(grid, visited, i - 1, j);
         }
         if(0 <= j-1 ) {
            if(!visited[i][j-1])
               explore(grid, visited, i, j - 1);
         }
         if(i+1 < numRows ) {
            if(!visited[i+1][j])
               explore(grid, visited, i + 1, j);
         }
         if(j+1< numColumns) {
            if(!visited[i][j+1])
               explore(grid, visited, i, j + 1);
         }
      }
   }



   public static void main(String[] args){
      char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
      };
      char[][] grid2 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','1'}
      };
      char[][] grid3 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
      };
      char[][] grid4 = {
            {'1','1','1' },
            {'0','1','0'},
            {'1','1','1'}
      };
      int x = numIslands2(grid2);
      System.out.println(x);
   }



}