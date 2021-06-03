package Binary;

public class Number_of_One_Bits {

   public static int hammingWeight(int n) {
      //we are ignoring sign
      int numberOfOneBits = 0;
      while (n!=0){
         numberOfOneBits += (n&1);
         n = n >>> 1;  //note that if we usage >> we will get infinite loop for -ve numbers
      }
      return numberOfOneBits;
   }
   public static void main(String [] args){
      int weight = hammingWeight(-3);
      System.out.println(weight);
   }

   static void inspectNumber(Integer y) {
      System.out.println(  "Int: "+ y + " Binary: "+ Integer.toBinaryString(y));
   }
}
