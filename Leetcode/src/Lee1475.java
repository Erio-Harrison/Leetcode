package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lee1475 {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int length = prices.length;

        for(int i=0;i<length;i++){
            while(!stack.isEmpty()&&prices[i]<=prices[stack.peek()]){
                int index = stack.pop();
                prices[index] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
