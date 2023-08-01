package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lee438 {
    public List<Integer> findAnagrams1(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        // Initialize the frequency count for p and the first window in s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Slide the window over s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isMatch(pCount, sCount)) {
                result.add(i);
            }
            if (i < s.length() - p.length()) {
                sCount[s.charAt(i) - 'a']--;  // Remove the leftmost character of the current window
                sCount[s.charAt(i + p.length()) - 'a']++;  // Add the next character in s to the window
            }
        }

        return result;
    }

    private boolean isMatch(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
