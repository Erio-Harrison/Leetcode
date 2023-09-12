package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lee437 {
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int countRoot =(int) findPaths(root,targetSum);
        int countLeft=pathSum(root.left,targetSum);
        int countRight=pathSum(root.right,targetSum);
        return countRoot+countRight+countLeft;
    }
    public long findPaths(TreeNode root,long targetSum){
        if(root==null){
            return 0;
        }
        long count=0;
        if(root.val==targetSum){
            count++;
        }
        count+=findPaths(root.left,targetSum-root.val);
        count+=findPaths(root.right,targetSum-root.val);
        return count;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // for paths starting from the root
        return findPaths1(root, 0L, targetSum, prefixSumCount);
    }

    private int findPaths1(TreeNode root, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (root == null) {
            return 0;
        }

        currentSum += root.val;
        int pathsToCurrent = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        int res = pathsToCurrent + findPaths1(root.left, currentSum, targetSum, prefixSumCount)
                + findPaths1(root.right, currentSum, targetSum, prefixSumCount);

        // Restore the map, as we move back to the parent node after the recursive call.
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return res;
    }
}
