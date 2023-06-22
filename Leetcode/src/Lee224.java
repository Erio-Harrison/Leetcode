package src;

import java.util.Stack;

public class Lee224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result=0;
        int number=0;
        int sign =1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number=number*10+ ch-'0';
            }else if(ch=='+'){
                result+=sign*number;
                number=0;
                sign=1;
            }else if(ch=='-'){
                result+=sign*number;
                number=0;
                sign=-1;
            }else if(ch=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }else if(ch==')'){
                result +=sign*number;
                sign=1;
                number=0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        result+=sign * number;
        return result;
    }
}
