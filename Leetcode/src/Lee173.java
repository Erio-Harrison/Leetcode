package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lee173 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    Queue<Integer> queue;

    public Lee173(TreeNode root) {
        queue = new LinkedList<>();
        inOrder(root,queue);
    }
    public void inOrder(TreeNode root,Queue<Integer> queue){
        if(root==null) return;
        inOrder(root.left,queue);
        queue.add(root.val);
        inOrder(root.right,queue);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
