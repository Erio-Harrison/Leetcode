package src;

import java.util.ArrayList;
import java.util.List;

public class Lee144 {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }
        preorderHelp(root,result);
        return result;
    }

    public void preorderHelp(TreeNode root,List<Integer> list){
          if(root==null){
              return;
          }
          list.add(root.val);
          preorderHelp(root.left,list);
          preorderHelp(root.right,list);
    }
}
