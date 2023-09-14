package src;


public class Lee538 {
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

    public TreeNode convertBST(TreeNode root) {
        convertHelp(root, new int[]{0});
        return root;
    }

    public void convertHelp(TreeNode root,int[] sum) {
        if(root==null)return;
        convertHelp(root.right,sum);

        root.val+=sum[0];
        sum[0]=root.val;

        convertHelp(root.left,sum);
      }
}
