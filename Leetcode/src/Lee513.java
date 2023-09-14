package src;

import java.util.LinkedList;
import java.util.Queue;

public class Lee513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode current = null;

        while(!queue.isEmpty()) {
            current = queue.poll();

            if(current.right != null) queue.add(current.right);
            if(current.left != null) queue.add(current.left);
        }

        return current.val;
    }
}
