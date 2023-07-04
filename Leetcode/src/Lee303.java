package src;

public class Lee303 {
    private int[] arr;
    public void NumArray(int[] nums) {
        arr = new int[nums.length+1];
        System.arraycopy(nums, 0, arr, 0, nums.length);
    }

    public int sumRange(int left, int right) {
        int result = 0;
        for(int i=left;i<=right;i++){
            result+=arr[i];
        }
        return result;
    }

    private int[] prefixSum;

    public void NumArray1(int[] nums) {
        //In Java, when an array of integers is created,
        //it is automatically initialized with zeroes in all positions.
        //So when you declare prefixSum as new int[nums.length + 1],
        //the position prefixSum[0] automatically gets the value 0.
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange1(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
