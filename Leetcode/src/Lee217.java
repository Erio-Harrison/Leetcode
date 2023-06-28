package src;

import java.util.HashSet;
import java.util.Set;

public class Lee217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i : nums){
                if(!set.contains(i)){
                    set.add(i);
                }else{
                    return true;
                }
            }
            return false;
        }
    }
}
