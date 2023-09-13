package src;

public class Lee129 {
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

    public int sumNumbers(TreeNode root) {
        return sumHelper(root,0);
    }

    public static int sumHelper(TreeNode root,int currentSum){
        if(root==null){
            return 0;
        }
        currentSum = currentSum*10+root.val;
        if(root.left==null&&root.right==null){
            return currentSum;
        }
        return sumHelper(root.left,currentSum)+sumHelper(root.right,currentSum);
    }
}
