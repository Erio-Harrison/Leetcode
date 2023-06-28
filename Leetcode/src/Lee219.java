package src;


import java.util.HashMap;

public class Lee219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=nums.length;i++){
            if(map.containsKey(nums[i-1])){
                if(i-map.get(nums[i-1])<=k){
                    return true;
                }
            }
            map.put(nums[i-1],i);
        }
        return false;
    }
}
