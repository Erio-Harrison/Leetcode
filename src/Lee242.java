package src;

import java.util.HashMap;
import java.util.Objects;

public class Lee242 {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }
        HashMap<String,Integer> map =new HashMap<>();
        for(int i=0;i<s.length();i++){
            String key =s.substring(i,i+1);
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }
        }
        HashMap<String,Integer> map2 =new HashMap<>();
        for(int i=0;i<t.length();i++){
            String key =t.substring(i,i+1);
            if(!map2.containsKey(key)){
                map2.put(key,1);
            }else{
                map2.put(key,map2.get(key)+1);
            }
        }
        for(String i:map.keySet()){
            if(!map2.containsKey(i)){
                return false;
            }
            if(!Objects.equals(map2.get(i), map.get(i))){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if(s.length()!= t.length()) return false;
        int [] char_sequence = new int[26];
        for(int i =0 ; i<s.length();i++){
            char_sequence[s.charAt(i)-'a']++;
            char_sequence[t.charAt(i)-'a']--;
        }
        for (int j : char_sequence) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

}
