package Dynamic_Programming;

public class Change_Cominations {

   public static int numberOfCombinations(int[] coins, int amount){
      int[][] numberOfCombs = new int[coins.length+1][amount+1];//grid has (no of denominations + 1) rows and (amount +1) columns
      numberOfCombs[0] =firstRowCombs(amount);
      for(int i=1;i<=coins.length;i++){
         for(int j=0;j<=amount;j++){
            int leftSet = (j-coins[i-1]>=0)? numberOfCombs[i][j-coins[i-1]]:0;
            int topSet = numberOfCombs[i-1][j];
            numberOfCombs[i][j] = leftSet + topSet;
         }
      }
      return numberOfCombs[coins.length][amount];
   }

   public static int[] firstRowCombs(int amount){
      int[] firstRow = new int[amount+1];
      for(int i=0;i<amount;i++){
         firstRow[i] = 0;
      }
      firstRow[0] = 1;
      return firstRow;
   }



   public static void main(String[] args){
      int result = numberOfCombinations(new int[]{1,2,3},4);
      System.out.println("End");
   }
}