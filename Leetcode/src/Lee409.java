package src;

import java.util.HashMap;
import java.util.Map;

public class Lee409 {

    public static int longestPalindrome1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int length =0;
        boolean oddExsit = false;
        for(int count : map.values()){
            length += count/2*2;
            if(count%2==1){
                oddExsit = true;
            }
        }
        if(oddExsit){
            length+=1;
        }
        return length;
    }
    public static int longestPalindrome2(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddExists = false;
        for (int count : charCount.values()) {
            length += count / 2 * 2;
            if (count % 2 == 1) {
                oddExists = true;
            }
        }

        if (oddExists) {
            length += 1;
        }

        return length;
    }
}
