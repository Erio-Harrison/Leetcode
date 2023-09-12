package src;

public class Lee450 {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null)return root.right;
            else if(root.right==null) return root.left;

            root.val=maxLeft(root.left);
            root.left=deleteNode(root.left,root.val);
        }
        return root;
    }
    public static int maxLeft(TreeNode root){
        int maxValue;
        while(root.right!=null){
            root=root.right;
        }
        maxValue = root.val;
        return maxValue;
    }
}
