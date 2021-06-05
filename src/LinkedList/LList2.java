package LinkedList;

public class LList2 {
   int val;
    LList2 next;
    LList2() {}
    LList2(int val) { this.val = val; }
    LList2(int val, LList2 next) { this.val = val; this.next = next; }

   public static LList2 buildList(int[] nums) {
      LList2 head = new LList2(nums[0]);
      LList2 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList2(nums[i]);
         cur = cur.next;
      }
      return head;
   }


   public static boolean hasCycle(LList2 head) {
       //Floyd Algorithm of detecting cycles
      //we run two pointers with different speed. Such that their relative speed is 1x and individual speeds are 2x and 1x
      LList2 singlePointer = head;
      LList2 doublePointer = head;
      while (singlePointer!=null & doublePointer!= null){
         singlePointer = singlePointer.next;
         if(doublePointer.next!=null){
            doublePointer = doublePointer.next.next;
         }
         else {
            break;
         }
         if(singlePointer == doublePointer)
            return true;
      }
      return false;
   }

   public static void main(String [] args){
       LList2 l = buildList(new int[]{1,2,3,4,5});
       l.next = l;
       boolean b = hasCycle(l);


    }
}
