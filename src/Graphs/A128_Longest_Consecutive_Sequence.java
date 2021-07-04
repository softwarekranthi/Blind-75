package Graphs;

import java.util.HashSet;
import java.util.Set;

public class A128_Longest_Consecutive_Sequence {

   public static int longestConsecutive(int[] nums) {
      Set<Integer> num_set = new HashSet<Integer>();
      for(int num: nums)
         num_set.add(num);
      int longestStreak =0;
      for (int num: nums){
         if(!num_set.contains(num-1)){
            int currentStreak = 1;
            int current = num;
            while (num_set.contains(++current))
               currentStreak++;
            longestStreak = Math.max(currentStreak,longestStreak);
         }
      }
     return longestStreak;
   }

   public static void main(String[] args){
      int n = longestConsecutive(new int[]{100,4,200,1,3,2});
      System.out.println(n);
   }
}

