package src;

import java.util.ArrayList;
import java.util.List;

public class Lee99 {
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
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(list,root);
        TreeNode first=null, second =null;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i).val>list.get(i+1).val){
                second = list.get(i+1);
                if (first == null) {
                    first = list.get(i);
                }
            }
        }
        int temp = second.val;
        second.val = first.val;
        first.val= temp;
    }
    public void inorder(List<TreeNode> list, TreeNode root){
          if(root==null) return;
          inorder(list,root.left);
          list.add(root);
          inorder(list,root.right);
    }

    public void recoverTree1(TreeNode root) {
        inorder1(root);
        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    TreeNode first = null, second = null, prev = null;
    private void inorder1(TreeNode root) {
        if (root == null) return;

        inorder1(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;

        inorder1(root.right);
    }
}
