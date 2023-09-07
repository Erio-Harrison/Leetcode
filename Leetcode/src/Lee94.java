package src;


import java.util.ArrayList;
import java.util.List;

public class Lee94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();

         if(root==null){
          return list;
         }
         inorderHelper(root,list);
         return list;
    }
    public void inorderHelper(TreeNode root,List<Integer> list){
     if(root==null){
      return;
     }
     inorderHelper(root.left,list);
     list.add(root.val);
     inorderHelper(root.right,list);
    }
}
