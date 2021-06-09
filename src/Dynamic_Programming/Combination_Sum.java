package Dynamic_Programming;

public class Combination_Sum {

   public static  int combinationSum4(int[] nums, int target) {
      int[] cache = new int[target+1];//no issue
      for (int i=0; i<cache.length; i++)
         cache[i]=-1;
      cache[target]=1;//this should be 1. Ponder more on this
      for (int i=0; i<=cache.length-2; i++) {
         fillCache(nums, i, cache);
      }
      return cache[0];
   }

   public static void fillCache(int[] denominations, int index, int[] cache){
      int sumOfAll = 0;
      for (int ith_denomination : denominations) {
         int cur_plus_ithDen = index + ith_denomination;
         if(cur_plus_ithDen< cache.length) {
            if(cache[cur_plus_ithDen]==-1)
               fillCache(denominations, cur_plus_ithDen, cache);
            sumOfAll += cache[cur_plus_ithDen];
         }
      }
      System.out.println("cache["+ index+ "]" + "= " + sumOfAll );
      cache[index] = sumOfAll;
   }


   public static void main(String[] args){
      int x = combinationSum4(new int[]{1,2,3},4);
      System.out.println(x);
   }

}
