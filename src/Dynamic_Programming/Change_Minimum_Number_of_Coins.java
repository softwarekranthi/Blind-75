package Dynamic_Programming;

public class Change_Minimum_Number_of_Coins {

   public static int minCoins(int[] coins, int amount){
      int[][] minCoins = new int[coins.length+1][amount+1];//grid has (no of denominations + 1) rows and (amount +1) columns
      minCoins[0] =firstRowMinCoins(amount);
      for(int i=1;i<=coins.length;i++){
         for(int j=0;j<=amount;j++){
            int topMinCoins  = minCoins[i-1][j];
            int min =topMinCoins;
            int leftIndex= j-coins[i-1];
            if (leftIndex>=0) {
               int leftMinCoins = minCoins[i][j-coins[i-1]];
               if(leftMinCoins==-1 & topMinCoins==-1)
                  min =-1;
               else if(topMinCoins==-1)
                  min = leftMinCoins+1;
               else if(leftMinCoins==-1)
                  min = topMinCoins;
               else
                  min = Integer.min(leftMinCoins+1, topMinCoins);
            }
            minCoins[i][j] = min;
         }
      }
      return minCoins[coins.length][amount];
   }

   public static int[] firstRowMinCoins(int amount){
      int[] firstRow = new int[amount+1];
      for(int i=0;i<=amount;i++){
         firstRow[i] = -1;
      }
      firstRow[0] = 0;
      return firstRow;
   }



   public static void main(String[] args){
      int result = minCoins(new int[]{1,2,5},11);
      System.out.println("End");
   }
}
