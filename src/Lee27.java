package src;

public class Lee27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i : nums) {
            if (i != val) {
                nums[count] = i;
                count += 1;
            }
        }
        return nums.length;
    }
}
