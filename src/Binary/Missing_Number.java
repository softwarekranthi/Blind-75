package Binary;

public class Missing_Number {
   public static int missingNumber(int[] nums) {
      //In total there are n+1 numbers 0,1,2,...n
      int arraySize = nums.length;              //arraySize is n, as 1 number missing among n+1 elts
      int actualSum = arraySize * (arraySize + 1) / 2;    //sum of the 1,2,...n i.e. n elts
      int missingSum = 0;
      for (int i = 0; i < arraySize; i++){
         missingSum += nums[i];
      }
      return actualSum - missingSum;
   }

   public static void main(String[] args){
      int missingNumber = missingNumber(new int[]{0, 1});
      System.out.println(missingNumber);
   }
}
