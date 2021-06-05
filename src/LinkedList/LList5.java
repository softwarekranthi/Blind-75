package LinkedList;

public class LList5 {
   int val;
    LList5 next;
    LList5() {}
    LList5(int val) { this.val = val; }
    LList5(int val, LList5 next) { this.val = val; this.next = next; }

   public static LList5 buildList(int[] nums) {
      LList5 head = new LList5(nums[0]);
      LList5 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList5(nums[i]);
         cur = cur.next;
      }
      return head;
   }


   public static LList5 removeNthFromEnd(LList5 head, int n) {
       //n is the gap on right
      LList5 nDistanceFarPointer = head;
      int count = 1;
      while (count <= n){
         count = count+1;
         nDistanceFarPointer = nDistanceFarPointer.next;
      }
      //if NDistance FarPointer = null
      LList5 currentPointer = head;    //it Points to head
      LList5 prevPointer = null;//it points to the element before head
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

   public static void reorderList(LList5 head) {
      while (true) {
         LList5 lastNode = deleteAndGetLast(head);
         if(lastNode==null) break;
         LList5 second = head.next;
         head.next = lastNode;
         lastNode.next = second;
         head = head.next.next;
      }
      System.out.println("Break");
   }
   public static LList5 deleteAndGetLast(LList5 head){
       LList5 cur = head;
       LList5 prev = head;
       if(cur==null){//empty list
          return null;
       }
       if(cur.next==null){//Single Node list
         head = null;
         return null;
      }
       cur = cur.next;
       while(cur.next!=null){
          cur = cur.next;
          prev = prev.next;
       }
       prev.next = null;
       return cur;
   }


   public static void main(String [] args){
      LList5 l5 = buildList(new int[]{1,2});
      LList5 l6 = removeNthFromEnd(l5,2);
      LList5 l7 = buildList(new int[]{1,2,3,4,5,6,7,8,9,10});
      reorderList(l7);
      System.out.println("End");


    }
}
