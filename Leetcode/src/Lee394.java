package src;

import java.util.Stack;

public class Lee394 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int number=0;
        StringBuilder current = new StringBuilder();

        for(char i:s.toCharArray()){
            if(Character.isDigit(i)){
                number=number*10+i-'0';
            }else if(i=='['){
                countStack.push(number);
                number=0;
                stringStack.push(current);
                current=new StringBuilder();
            }else if(i==']'){
                StringBuilder string = stringStack.pop();
                for(int count=countStack.pop();count>0;count--){
                    string.append(current);
                }
                current=string;
            }else{
                current.append(i);
            }
        }
        return current.toString();
    }

    int index=0;
    public String decodeString1(String s) {
        StringBuilder result = new StringBuilder();

        while(index<s.length()&&s.charAt(index)!=']'){
            if(!Character.isDigit(s.charAt(index))){
                result.append(s.charAt(index++));
            }else{
                int number=0;
                while(index<s.length()&&Character.isDigit(s.charAt(index))){
                    number=number*10+s.charAt(index++)-'0';
                }
                ++index;
                String string = decodeString1(s);
                ++index;
                while(number-->0){
                    result.append(string);
                }
            }
        }
        return result.toString();
    }

}
