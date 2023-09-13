package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lee230 {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return -1;
        }
        findHelper(root,list);
        return list.get(list.size()-k+1);
    }

    public void findHelper(TreeNode root,List<Integer> list){
        findHelper(root.left,list);
        list.add(root.val);
        findHelper(root.right,list);
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
        return -1;  // This should never be reached as k is always valid
    }
}
