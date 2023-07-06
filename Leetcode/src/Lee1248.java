package src;

public class Lee1248 {
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int odd = 0, result = 0;

        count[0] = 1;

        for (int i = 0; i < n; i++) {
            odd += nums[i] % 2;
            if (odd >= k) {
                result += count[odd - k];
            }
            count[odd]++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1,1},3));
    }
}
