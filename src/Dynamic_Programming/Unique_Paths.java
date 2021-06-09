package Dynamic_Programming;

public class Unique_Paths {
   public static int uniquePaths(int m, int n) {
      int[][] grid = new int[m][n];
      //X=0 line
      for(int i=0; i<m; i++)
         grid[i][0] = 1;
      //Y=0 Line
      for(int j=0; j<n; j++)
         grid[0][j] = 1;
      for(int i=1; i<m; i++) {
         for (int j = 1; j < n; j++) {
            grid[i][j] = grid[i-1][j] + grid[i][j-1];
         }
      }
      return grid[m-1][n-1];
   }
   public static void main(String[] args){
      int ans = uniquePaths(3,7);
      System.out.println(ans);
   }

}
