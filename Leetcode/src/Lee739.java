package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Lee739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(int i=0;i<length;i++){
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int index = stack.pop();
                answer[i] = i-index;
            }
            stack.push(i);
        }
        return answer;

    }
}
