package src;

import java.util.LinkedList;

public class Lee116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre =null;

            for(int i=0;i<size;i++){
                Node current = queue.poll();

                if(pre!=null){
                    pre.next=current;
                }
                pre=current;

                if(current.left!=null)queue.add(current.left);
                if(current.right!=null)queue.add(current.right);

            }
            pre.next = null;

        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) return null;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (i < size - 1) {
                    current.next = queue.peek();
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return root;
    }
}
