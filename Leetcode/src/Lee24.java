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
        ListNode secondNode = head.next;

        // Swapping
        head.next = swapPairs(secondNode.next);
        secondNode.next = head;

        // Return new head node
        return secondNode;
    }
    public ListNode swapPairs1(ListNode head) {
        // Creating dummy node
        ListNode dummy = new ListNode(-1);
        // Point the next of dummy node to the head
        dummy.next = head;
        // Creating a pointer to track the pair of nodes
        ListNode point = dummy;

        while (point.next != null && point.next.next != null) {
            // Initializing first node of pair
            ListNode firstNode = point.next;
            // Initializing second node of pair
            ListNode secondNode = point.next.next;

            // Swapping the nodes
            firstNode.next = secondNode.next;
            point.next = secondNode;
            secondNode.next = firstNode;

            // Updating the pointer to the next pair
            point = firstNode;
        }
        return dummy.next;
    }
}
