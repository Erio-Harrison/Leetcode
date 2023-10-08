package src;

import java.util.Stack;

public class Lee98 {
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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long minVal, long maxVal) {
        if (node == null) return true;

        if (node.val <= minVal || node.val >= maxVal) return false;

        boolean leftIsValid = isValidBSTHelper(node.left, minVal, node.val);
        boolean rightIsValid = isValidBSTHelper(node.right, node.val, maxVal);

        return leftIsValid && rightIsValid;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre=null;
        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                if(pre!=null&&pre.val>=node.val) return false;
                pre=node;
                node=node.right;
            }
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root,Long min,Long max){
          if(root==null) return true;
          if(min>=root.val||max<=root.val) return false;

          boolean left = isValidBSTHelper(root.left,min,root.val);
          boolean right = isValidBSTHelper(root.right,root.val,max);

          return left&&right;
    }

}
