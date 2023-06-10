package src;

public class Lee26 {
    public static int removeDuplicates(int[] nums) {
        int newIndex = 1; // Start with index 1 because the first element is already in place

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i+1]) { // If the current element is less than the next element

                nums[newIndex] = nums[i+1]; // Move the next element to the new index
                newIndex++; // Increment the new index
            }
        }
        for(int i:nums){
            System.out.print(i);
        }
        System.out.println();
        return newIndex; // Return the length of the new subarray
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,1,1,1,2,3}));
    }
}
