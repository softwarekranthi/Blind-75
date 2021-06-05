package LinkedList;

public class LList4 {
   int val;
    LList4 next;
    LList4() {}
    LList4(int val) { this.val = val; }
    LList4(int val, LList4 next) { this.val = val; this.next = next; }

   public static LList4 buildList(int[] nums) {
      LList4 head = new LList4(nums[0]);
      LList4 cur = head;
      for (int i=1; i<nums.length; i++){
         cur.next = new LList4(nums[i]);
         cur = cur.next;
      }
      return head;
   }



   public static LList4 mergeKLists(LList4[] lists) {
      LList4 sentinelHead = new LList4();
      LList4 cur = sentinelHead;
      while (true) {
         int minIndex = -1;//stores the array of te linkedlist whose head has the minimum element
         for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null ) {
               if(minIndex==-1){
                  minIndex = i;// updates the minIndex to first element found among all lists
               }
               else{
                  if(lists[minIndex].val > lists[i].val) {
                     minIndex = i;// updates the minIndex to min element from first element
                  }
               }
            }
         }
         if(minIndex!=-1) {
            cur.next = new LList4(lists[minIndex].val);;
            cur = cur.next;//means that we have not found a single index forget even min which can happen only during all  lists being empty
            lists[minIndex] = lists[minIndex].next;
         }
         else{
            break;
         }
      }
      return sentinelHead.next;
   }



   public static void main(String [] args){

      LList4[] listArray = new LList4[]{buildList(new int[]{1,4,5}), buildList(new int[]{1,3,4}), buildList(new int[]{2,6})};
      LList4 unifiedList = mergeKLists(listArray);

      System.out.println("End");


    }
}
