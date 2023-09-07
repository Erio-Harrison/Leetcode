package src;

import java.util.ArrayList;
import java.util.List;

public class Lee95 {
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if(start>end){
            result.add(null);
            return result;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftTrees = generateTrees(start,i-1);
            List<TreeNode> rightTrees = generateTrees(i+1,end);

            for(TreeNode left:leftTrees){
                for(TreeNode right:rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left =left;
                    root.right =right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
