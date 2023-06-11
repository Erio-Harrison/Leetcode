package src;

public class Lee24 {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode swapPairs(ListNode head) {
        // If the list is empty (head is null) or there is only one node left
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Return new head node
        return secondNode;
    }
}
