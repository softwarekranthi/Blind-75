package Binary;

public class Sum_of_Two_Integers {

   public static int getSum(int a, int b) {
      //imagine bitwise muliplication on paper
      while (b!=0){ //we stop when we dont have any common digits between and b. No carry
         int carry = a&b;//carry means common digits
         a = a^b;//all the bits that are different become 1
         b = carry << 1;// all the bits that are common multiply with two
      }
      return a;
   }


   public static void main(String [] args){
      int a = 8;
      int b = 11;
      int sum = getSum(a,b);
      System.out.println(sum);
   }

   static void inspectNumber(Integer y) {
      System.out.println(  "Int: "+ y + " Binary: "+ Integer.toBinaryString(y));
   }

}
