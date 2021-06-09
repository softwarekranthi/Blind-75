package Dynamic_Programming;

public class House_Robber {

   public static int rob2(int[] nums) {//Without Using array as we just need the last two pointers
      return 0;

   }
   public static int rob(int[] nums) {//Using array
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
      int result = rob(new int[]{1,2,3,1});
      System.out.println(result);
   }

}
