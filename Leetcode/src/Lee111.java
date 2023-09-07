package src;

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
    public int fun(TreeNode root){
        if(root==null)
            return 10000;
        if(root.left==null && root.right==null)
            return 1;
        return 1+Math.min(fun(root.left),fun(root.right));
    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return fun(root);
    }
}
