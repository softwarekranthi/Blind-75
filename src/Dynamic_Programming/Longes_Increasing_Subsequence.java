package Dynamic_Programming;

import java.lang.management.MonitorInfo;

public class Longes_Increasing_Subsequence {


   public static int lengthOfLIS(int[] nums) {
      int[] len = new int[nums.length];   //len represents length_of_largest_Subsequence_Till_N
      for (int i=0; i<nums.length; i++ )
         len[i] =1;
      for (int i=1; i<nums.length; i++ ){
         int max_till_index_j = -1;
         for (int j=0; j<i; j++){
            if( nums[i]>nums[j] & len[j]>max_till_index_j)
               max_till_index_j = len[j];
         }
         if(max_till_index_j!=-1)
            len[i] = max_till_index_j + 1;
      }
      int max = Integer.min(nums.length,1);
      for (int i=1; i<nums.length; i++ )
         max = Integer.max(max, len[i]);
      return  max;
   }

   public static void main(String[] args){
      int result = lengthOfLIS(new int[]{0,1,0,3,2,3});
      System.out.println(result);
   }

}
