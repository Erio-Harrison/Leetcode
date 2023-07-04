package src;

public class Lee1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int odd = 0, result = 0;

        count[0] = 1; // This is to take care of the array starting with k odd numbers

        for (int num : nums) {
            odd += num % 2;  // Increment odd counter if nums[i] is odd
            if (odd >= k) {
                result += count[odd - k]; // Add the count of sub-arrays that has exactly k odd numbers.
            }
            count[odd]++;
        }

        return result;
    }
}
