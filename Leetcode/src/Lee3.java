package src;

import java.util.HashSet;
import java.util.Set;

public class Lee3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);

            if (!set.contains(ch)) {
                set.add(ch);
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbde"));
    }
}
