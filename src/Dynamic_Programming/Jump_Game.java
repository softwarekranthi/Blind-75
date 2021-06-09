package Dynamic_Programming;

public class Jump_Game {

   public static boolean canJump(int[] nums) {
      int[] reachableUptoN = new int[nums.length];
      reachableUptoN[0] = nums[0];
      for (int i=1; i<nums.length;i++){
         if(reachableUptoN[i-1]>=i) {
            reachableUptoN[i] = Integer.max(reachableUptoN[i - 1], i + nums[i]);
         }
      }
      return reachableUptoN[nums.length-1]>=nums.length-1;
   }
   public static void main(String[] args){
      boolean canJump = canJump(new int[]{2,3,1,1,4});
      System.out.println(canJump);
   }

}
