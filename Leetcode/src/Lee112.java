package src;

import java.util.ArrayList;
import java.util.List;

public class Lee112 {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        boolean leftHasPath = hasPathSum(root.left, targetSum - root.val);
        boolean rightHasPath = hasPathSum(root.right, targetSum - root.val);

        return leftHasPath || rightHasPath;
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }
    public boolean sum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        currentSum += root.val;

        // Check if it's a leaf node and if the current sum equals the target sum
        if (root.left == null && root.right == null && currentSum == targetSum) {
            return true;
        }

        // Recursively check left and right subtrees
        return sum(root.left, targetSum, currentSum) || sum(root.right, targetSum, currentSum);
    }
}
