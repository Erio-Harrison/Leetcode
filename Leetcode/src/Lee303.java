package src;

public class Lee303 {
    private int[] arr;
    public void NumArray(int[] nums) {
        arr = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }
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
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange1(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
