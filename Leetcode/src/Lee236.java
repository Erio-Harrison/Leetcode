package src;

public class Lee236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root==p||root==q) return root;

        TreeNode LcaLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode LcaRight = lowestCommonAncestor(root.right,p,q);

        if(LcaLeft!=null&&LcaRight!=null) return root;
        return LcaLeft!=null?LcaLeft:LcaRight;
    }
}
