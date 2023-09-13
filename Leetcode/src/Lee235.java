package src;

public class Lee235 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val<p.val&&root.val<q.val){
                root=root.right;
            } else if (root.val>p.val&&root.val>q.val) {
                root=root.left;
            }else{
                return root;
            }
        }
        return null;
    }
}
