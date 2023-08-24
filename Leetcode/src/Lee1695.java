package src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lee1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0,right=0,sum=0;
        int result = Integer.MIN_VALUE;
        int length =nums.length;
        Set<Integer> set = new HashSet<>();
        while(right<length){
            while(set.contains(nums[right])){
                sum-=nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[right]);
            sum+=nums[right++];
            result = Math.max(result,sum);
        }
        return result;
    }
}
