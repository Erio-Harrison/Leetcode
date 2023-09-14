package src;

public class Lee114 {
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

    public void flatten(TreeNode root) {

        if(root==null) return;
        flatten(root.left);
        flatten(root.right);

        if(root.left==null) return;

        TreeNode node = root.left;
        while(node.right!=null){
            node=node.right;
        }

        node.right=root.right;
        root.right=root.left;
        root.left=null;
    }
}
