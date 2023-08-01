package src;

public class Lee643 {
    public static double findMaxAverage1(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        if(nums.length<4){
            int number=0;
            for(int i:nums){
                number+=i;
            }
            result = Math.max(result,number);
            double q=(double)k;
            return result/q;
        }
        for(int i=0;i<=nums.length-k;i++){
            int number=0;
            for(int j=0;j<k;j++){
                number+=nums[i+j];
            }
            result = Math.max(result,number);
        }
        double o=(double)k;
        return result/o;
    }
    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = nums.length;
        if (k > n) {
            throw new IllegalArgumentException("k should be less than or equal to length of nums");
        }

        // Calculate the sum for the initial window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window over the rest of the array
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k]; // Add new element and subtract the starting element of the previous window
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
