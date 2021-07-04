package Dynamic_Programming;

public class Decode_String {
   public static int numDecodings(String s) {
      int[] dp = new int[s.length()+1];//default value is zero for all array elements
      dp[0] = 1;//base case crucial
      dp[1]=s.charAt(0)=='0' ? 0:1;
      for (int i=2; i<=s.length(); i++){//you start from i=2 because for every i we consider the two elements before it
         int oneDigit =Integer.parseInt(s.substring(i-1,i));//before i i.e. i-1
         int twoDigit =Integer.parseInt(s.substring(i-2,i));//before i i.e. i-2,i-1
         if(oneDigit>=1)
            dp[i] += dp[i-1];
         if(twoDigit>=10 && twoDigit<=26)
            dp[i]+=dp[i-2];
         //if no valid digits found then dp[i] will remain at zero
      }
      return dp[s.length()];
   }
   public static void main(String[] args){
      int ans = numDecodings("1");
   }
}
