package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lee76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int map[] = new int[128], len = t.length();

        for (int i = 0; i < len; i++) {
            map[t.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();
        String min = null;
        int currMap[] = new int[128];

        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            currMap[s.charAt(i)]++;
        }

        if (Arrays.equals(currMap, map)) {
            return sb.toString();
        }

        int left = 0, right = len;
        while (right < s.length()) {
            sb.append(s.charAt(right));
            currMap[s.charAt(right)]++;

            while (checkMap(currMap, map)) {
                if (min == null || sb.length() < min.length()) {
                    min = sb.toString();
                }
                currMap[s.charAt(left)]--;
                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }

        return min == null ? "" : min;
    }

    public boolean checkMap(int[] currMap, int[] map) {
        for (int i = 0; i < currMap.length; i++) {
            if (currMap[i] < map[i]) {
                return false;
            }
        }
        return true;
    }
    public String minWindow1(String s, String t) {
        if(s.isEmpty() || t.isEmpty()){
            return "";
        }

        int left=0,right=0,formed=0;
        HashMap<Character,Integer> mapT = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            int count = mapT.getOrDefault(ch,0);
            mapT.put(ch,count+1);
        }
        int required = mapT.size();
        int[] result = {-1,0,0};

        HashMap<Character,Integer> windowsCount = new HashMap<>();

        while(right<s.length()){
            char charRight = s.charAt(right);
            int count2= windowsCount.getOrDefault(charRight,0);
            windowsCount.put(charRight,count2+1);

            if(mapT.containsKey(charRight)&&windowsCount.get(charRight).intValue()==mapT.get(charRight).intValue()){
                formed++;
            }

            while(formed==required){
                char charLeft = s.charAt(left);
                if(result[0] == -1 || right-left+1 < result[0]){
                    result[0] = right-left+1;
                    result[1] = left;
                    result[2] = right;
                }
                windowsCount.put(charLeft,windowsCount.get(charLeft)-1);
                if(mapT.containsKey(charLeft)&& windowsCount.get(charLeft) < mapT.get(charLeft)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return result[0]==-1 ? "" : s.substring(result[1],result[2]+1);
    }
}
