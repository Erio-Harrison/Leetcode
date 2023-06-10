package src;

import java.util.Stack;

public class Lee20 {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(st.empty()) return false;

            else if(st.peek()=='(' && c==')'&&!st.isEmpty()){
                st.pop();
            }
            else if(st.peek()=='['&&c==']'&&!st.isEmpty()){
                st.pop();
            }
            else if(st.peek()=='{'&&c=='}' &&!st.isEmpty()){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
}
