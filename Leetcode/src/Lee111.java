package src;

import java.util.LinkedList;
import java.util.Queue;

public class Lee111 {
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
    public int depth(TreeNode root){
        if(root==null)
            return 100000;
        if(root.left==null && root.right==null)
            return 1;
        return 1+Math.min(depth(root.left),depth(root.right));
    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return depth(root);
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();


                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
