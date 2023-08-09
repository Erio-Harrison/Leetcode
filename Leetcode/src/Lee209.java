package src;

public class Lee209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int left=0,right=0,sum=0;

        while(right<nums.length){
            sum += nums[right];
            right++;

            while(sum>=target){
                length = Math.min(length,right-left);
                sum -= nums[left];
                left++;
            }
        }
        return length==Integer.MAX_VALUE ? 0:length;
    }
}
