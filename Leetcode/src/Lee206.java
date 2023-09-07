package src;

public class Lee206 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        ListNode current = head;
        while(current!=null){
            ListNode next = current.next;
            current.next=dummy;
            dummy=current;
            current=dummy;
        }
        return dummy;
    }
}
