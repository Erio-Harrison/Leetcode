package src;

public class Lee19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        int length =0;
        ListNode point=head;
        while(point!=null){
            point=point.next;
            length+=1;
        }
        length-=n;
        ListNode point2=dummy;
        while(length>0){
            point2=point2.next;
            length--;
        }
        if(point2.next!=null){
            point2.next=point2.next.next;
        }
        return dummy.next;
    }
}
