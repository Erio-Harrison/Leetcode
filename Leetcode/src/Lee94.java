package src;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Lee94 {
    public static class TreeNode {
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

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node=root;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                result.add(node.val);
                node=node.right;
            }
        }
        return result;
    }

    class Solution {
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> result = new LinkedList<>();

            // Base case: if root is null, simply return the result
            if (root == null) {
                return result;
            }

            // Traverse the left subtree
            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }

            // Visit the root
            result.add(root.val);

            // Traverse the right subtree
            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }

            return result;
        }
    }
}
