package src;

public class Lee75 {
    public void sortColors(int[] nums) {
        int left = 0, current = 0, right = nums.length - 1;
        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, current, left);
                left++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
