package src;

import java.util.Stack;

public class Lee20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char str = s.charAt(i);
            if(str=='('||str=='{'||str=='['){
                stack.push(str);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(str==')'&&stack.peek()=='('){
                stack.pop();
            }
            else if(str==']'&&stack.peek()=='['){
                stack.pop();
            }
            else if(str=='}'&&stack.peek()=='{'){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
