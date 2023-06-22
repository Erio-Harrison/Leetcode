package src;

import java.util.Stack;

public class Lee739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] answer = new int[length];
        Stack<Integer> stack = new Stack<Integer>();

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
