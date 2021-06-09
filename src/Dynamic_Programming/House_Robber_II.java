package Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class House_Robber_II {

   public static int rob_Circular(int[] nums) {
      if(nums.length==1)
         return nums[0];
      int[] arrayExcludingStart = Arrays.copyOfRange(nums,1,nums.length);
      int[] arrayExcludingEnd = Arrays.copyOfRange(nums,0,nums.length- 1);
      return Integer.max(rob_Non_Circular(arrayExcludingStart), rob_Non_Circular(arrayExcludingEnd));
   }
   public static int rob_Non_Circular(int[] nums) {//Using array
      int[] maxValue = new int[nums.length];
      maxValue[0]=nums[0];
      if(nums.length>1)
         maxValue[1]= Integer.max( nums[0], nums[1]);
      for (int i=2;i<nums.length; i++){
         maxValue[i] = Integer.max( (maxValue[i-2]+nums[i]), maxValue[i-1]);
      }
      return maxValue[maxValue.length-1];
   }

   public static void main(String [] args){
      int result = rob_Circular(new int[]{0});
      System.out.println(result);
   }


}
