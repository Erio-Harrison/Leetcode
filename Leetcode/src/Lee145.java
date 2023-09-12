package src;

import java.util.ArrayList;
import java.util.List;

public class Lee145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }
        postorderHelp(root,result);
        return result;
    }

    public void postorderHelp(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }

        postorderHelp(root.left,list);
        postorderHelp(root.right,list);
        list.add(root.val);
    }
}
