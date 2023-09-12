package src;

public class Lee404 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        int result=0;
        if(root==null){
            return 0;
        }
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            result+=root.left.val;
        }
        result+=sumOfLeftLeaves(root.left);
        result+=sumOfLeftLeaves(root.right);
        return result;

    }
}
