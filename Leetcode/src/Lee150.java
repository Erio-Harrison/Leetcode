package src;

import java.util.Stack;

public class Lee150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token :tokens){
            if(!"+-*/".contains(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }
            int number2=stack.pop();
            int number1=stack.pop();
            int result = switch (token) {
                case "+" -> number1 + number2;
                case "-" -> number1 - number2;
                case "*" -> number1 * number2;
                case "/" -> number1 / number2;
                default -> 0;
            };
            stack.push(result);
        }
        return stack.peek();

    }

}
