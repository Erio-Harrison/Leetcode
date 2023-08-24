package src;

import java.util.ArrayList;
import java.util.List;

public class Lee9 {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            list1.add(str.charAt(i));
        }
        for(int i=str.length()-1;i>=0;i--){
            list2.add(str.charAt(i));
        }
        for(int i = 0; i < str.length(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        String str = Integer.toString(x);
        int length = str.length();

        // Directly handle single-digit cases, including negative numbers.
        if (length <= 1) return x >= 0;

        for(int i = 0; i < length / 2; i++) {
            if(str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
