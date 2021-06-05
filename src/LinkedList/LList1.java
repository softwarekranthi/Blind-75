package LinkedList;

public class LList1 {
   int val;
    LList1 next;
    LList1() {}
    LList1(int val) { this.val = val; }
    LList1(int val, LList1 next) { this.val = val; this.next = next; }

   public static LList1 buildList(int[] nums) {
      LList1 head = new LList1(nums[0]);
      LList1 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList1(nums[i]);
         cur = cur.next;
      }
      return head;
   }

   public static LList1 reverseList(LList1 head) {
      LList1 tail = null;     //tail is the tail of new reversed List
      while (head!=null){
         tail = new LList1(head.val,tail);
         head=head.next;
      }
      return tail;
   }
 

   public static void main(String [] args){
       LList1 l = buildList(new int[]{1,2,3,4,5});
       LList1 lr = reverseList(l);
 

    }
}
