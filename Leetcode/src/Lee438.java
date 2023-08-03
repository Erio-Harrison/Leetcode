package src;

import java.util.*;

public class Lee438 {
    public List<Integer> findAnagrams1(String s, String p) {
        if(s==null||p==null||s.length()<p.length()){
            return new ArrayList<>();
        }
        int[] scount = new int[26];
        int[] pcount = new int[26];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            scount[s.charAt(i)-'a']++;
            pcount[p.charAt(i)-'a']++;
        }
        for(int i=0;i<=s.length()-p.length();i++){
            if(ismatch(scount,pcount)){
                result.add(i);
            }
            if(i<s.length()-p.length()){
                scount[s.charAt(i)-'a']--;
                scount[s.charAt(i+p.length())-'a']++;
            }

        }
        return result;
    }
    public boolean ismatch(int[] scount,int[] pcount){
        for(int i=0;i<26;i++){
            if(scount[i]!=pcount[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int counter = pMap.size();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (pMap.containsKey(endChar)) {
                pMap.put(endChar, pMap.get(endChar) - 1);
                if (pMap.get(endChar) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                if (end - start == p.length()) {
                    result.add(start);
                }

                char startChar = s.charAt(start);
                if (pMap.containsKey(startChar)) {
                    pMap.put(startChar, pMap.get(startChar) + 1);
                    if (pMap.get(startChar) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }

        return result;
    }

}
