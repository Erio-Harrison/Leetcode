package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Lee232 {
    class MyQueue {

        public MyQueue() {

        }
        Deque<Integer> stack = new LinkedList();
        public void push(int x) {
            stack.push(x);
        }
        public int pop() {
            return stack.remove();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
