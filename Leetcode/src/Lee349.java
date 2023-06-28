package src;

import java.util.HashSet;

public class Lee349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for(int i:nums2){
            set.add(i);
        }
        for(int i:nums1){
            if(set.contains(i)){
                result.add(i);
            }
        }
        int[] array = new int[result.size()];
        int index = 0;
        for (Integer value : result) {
            array[index++] = value;
        }

        return array;
    }
}
