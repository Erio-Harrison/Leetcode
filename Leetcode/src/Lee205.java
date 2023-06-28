package src;

import java.util.HashMap;

public class Lee205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            map.put(s.charAt(i),t.charAt(i));
            if(map2.containsKey(t.charAt(i))){
                if(map2.get(t.charAt(i))!=s.charAt(i)){
                    return false;
                }
            }
            map2.put(t.charAt(i),s.charAt(i));
        }
        return true;
    }
}
