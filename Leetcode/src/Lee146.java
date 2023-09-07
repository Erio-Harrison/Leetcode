package src;

import java.util.HashMap;

public class Lee146 {
    int capacity;
    HashMap<Integer, Node> cache;
    Node head,tail;
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
    }
    private void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre = node.pre;
    }
    private void addNodetoHead(Node node){
        node.next=head.next;
        head.next.pre = node;
        node.pre=head;
        head.next =node;

    }
    public Lee146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node();
        tail=new Node();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node==null){
            return -1;
        }
        removeNode(node);
        addNodetoHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node!=null){
            node.val=value;
            removeNode(node);
            addNodetoHead(node);
        }else{
            Node newNode = new Node();
            newNode.key=key;
            newNode.val=value;

            if(cache.size()>=capacity){
                Node lastNode = tail.pre;
                removeNode(lastNode);
                cache.remove(lastNode.key);
            }

            addNodetoHead(newNode);
            cache.put(key,newNode);
        }
    }
}
