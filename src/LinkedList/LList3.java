package LinkedList;

public class LList3 {
   int val;
    LList3 next;
    LList3() {}
    LList3(int val) { this.val = val; }
    LList3(int val, LList3 next) { this.val = val; this.next = next; }

   public static LList3 buildList(int[] nums) {
      LList3 head = new LList3(nums[0]);
      LList3 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList3(nums[i]);
         cur = cur.next;
      }
      return head;
   }


   public static LList3 mergeTwoLists(LList3 l1, LList3 l2) {
      LList3 headSentinel = new LList3();//we want sentinel node to maintain better recursion. We remove this while returining
      LList3 cur = headSentinel;
       while (true){
          if(l1==null){
             cur.next = l2;
             break;
          }
          else if(l2 == null){
             cur.next = l1;
             break;
          }
          else {
             if(l1.val< l2.val){
                cur.next = new LList3(l1.val, null);
                cur = cur.next;
                l1 = l1.next;
             }
             else {
                cur.next = new LList3(l2.val, null);
                cur = cur.next;
                l2 = l2.next;
             }
          }
       }
       return headSentinel.next;
   }


   public static LList3 removeNthFromEnd(LList3 head, int n) {
       //n is the gap on right
      LList3 nDistanceFarPointer = head;
      int count = 1;
      while (count <= n){
         count = count+1;
         nDistanceFarPointer = nDistanceFarPointer.next;
      }
      //if NDistance FarPointer = null
      LList3 currentPointer = head;    //it Points to head
      LList3 prevPointer = null;//it points to the element before head
      while (nDistanceFarPointer!=null){
         nDistanceFarPointer = nDistanceFarPointer.next;
         prevPointer = currentPointer;
         currentPointer = currentPointer.next;
      }
      if(prevPointer==null){
         head = head.next;
      }
      else {
         prevPointer.next = currentPointer.next;
      }
      return head;
   }



   public static void main(String [] args){

      LList3 l2 = buildList(new int[]{1,3,5,7,9});
      LList3 l3 = buildList(new int[]{2,4,6,8,10});
      LList3 merge = mergeTwoLists(l2,l3);
      System.out.println("End");


    }
}
