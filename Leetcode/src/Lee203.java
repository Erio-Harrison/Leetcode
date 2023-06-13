package src;

public class Lee203{
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode removeElements(ListNode head, int val) {
          if(head==null){
              return null;
          }
          ListNode dummy = new ListNode(0);
          dummy.next=head;
          ListNode point=dummy;
          while(point.next!=null){
              if(point.next.val==val){
                  point.next=point.next.next;
              }else{
                  point=point.next;
              }
          }
          return dummy.next;
      }

}
