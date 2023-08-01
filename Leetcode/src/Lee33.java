package src;

public class Lee33 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Find the pivot
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        // now left is the pivot
        int pivot = left;
        left = 0; right = nums.length - 1;

        // decide which part to do the binary search
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }

        // standard binary search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{8,9,1,2,3,4,5,6,7},1));
    }
}
