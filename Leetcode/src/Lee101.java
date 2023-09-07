package src;

public class Lee101 {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode left,TreeNode right){
          if(left==null&&right==null){
              return true;
          }
          if(left==null||right==null){
              return false;
          }
          return (left.val==right.val&&dfs(left.left,right.right)&&dfs(left.right,right.left));

    }
}
