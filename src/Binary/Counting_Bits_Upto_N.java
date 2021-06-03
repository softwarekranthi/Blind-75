package Binary;

/* Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

      Example 1:
      Input: n = 2
      Output: [0,1,1]
      Explanation:
      0 --> 0
      1 --> 1
      2 --> 10
      Example 2:

      Input: n = 5
      Output: [0,1,1,2,1,2]
      Explanation:
      0 --> 0
      1 --> 1
      2 --> 10
      3 --> 11
      4 --> 100
      5 --> 101
      Constraints:
      0 <= n <= 105
      Follow up:
      It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?

 */
public class Counting_Bits_Upto_N {

   public static int[] countBits(int n) {
      int[] result = new int[n+1];//n sized array with max index n-1
      result[0]=0;
      int twoPower = 1;
      while(twoPower <= n+1){
         int nextTwoPower = 2*twoPower;
         int upperCap = Math.min(n+1, nextTwoPower);
         for (int i=twoPower;i<upperCap;i++){
            result[i]=result[i-twoPower]+1;
         }
         twoPower = nextTwoPower;
      }
      return result;
   }

   public static void main(String[] args){
      int[] ans = countBits(16);

   }

}
