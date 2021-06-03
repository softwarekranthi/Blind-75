package Binary;

public class Reverse_Bits {


   public static int reverseBits(int n) {
      int result = 0;
      int i =0;
      while (i<32){
         int lastDigit = n&1;
         result = result <<1;
         result = result | lastDigit;
         System.out.println(lastDigit);
         n = n>>1;
         i++;
      }
      return result;
   }

   public static void main(String[] args){
      int x = reverseBits(-3);
   }
}
