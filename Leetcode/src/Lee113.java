package src;

import java.util.ArrayList;
import java.util.List;

public class Lee113 {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root,targetSum,new ArrayList<>(),result);
        return result;
    }
    public void findPaths(TreeNode root,int sum, List<Integer> current,List<List<Integer>> result){
        if(root==null){
            return;
        }
        current.add(root.val);
        if(root.left==null&&root.right==null&&root.val==sum){
            result.add(new ArrayList<>(current));
        }else{
            findPaths(root.left,sum-root.val,current,result);
            findPaths(root.right,sum-root.val,current,result);
        }
        current.remove(current.size()-1);
    }
}
