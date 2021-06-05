package LinkedList;

public class LList6 {
   int val;
    LList6 next;
    LList6() {}
    LList6(int val) { this.val = val; }
    LList6(int val, LList6 next) { this.val = val; this.next = next; }

   public static LList6 buildList(int[] nums) {
      LList6 head = new LList6(nums[0]);
      LList6 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList6(nums[i]);
         cur = cur.next;
      }
      return head;
   }


   public static void reorderList(LList6 head) {
      while (true) {
         LList6 lastNode = deleteAndGetLast(head);
         if(lastNode==null) break;
         LList6 second = head.next;
         head.next = lastNode;
         lastNode.next = second;
         head = head.next.next;
      }
      System.out.println("Break");
   }
   public static LList6 deleteAndGetLast(LList6 head){
       LList6 cur = head;
       LList6 prev = head;
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
      LList6 l7 = buildList(new int[]{1,2,3,4,5,6,7,8,9,10});
      reorderList(l7);
      System.out.println("End");


    }
}
