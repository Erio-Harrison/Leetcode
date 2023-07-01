package src;

import java.util.HashMap;

public class Lee724 {
    public int pivotIndex1(int[] nums) {
        int result= -1;
        for(int i=0;i<nums.length;i++){
            int result1=0;
            int result2=0;
            for(int j=0;j<i;j++){
                result1+=nums[j];
            }
            for(int k=i+1;k<nums.length;k++){
                result2+=nums[k];
            }
            if(result1==result2){
                return i;
            }
        }
        return result;
    }
    public int pivotIndex2(int[] nums) {
        // First, calculate the total sum of the array
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        // Then, keep a running sum and update it as we traverse the array.
        // If at any point, runningSum * 2 + currentElement equals totalSum,
        // it means we've found a pivot index.
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(runningSum * 2 == totalSum - nums[i]) {
                return i;
            }
            runningSum += nums[i];
        }

        // If no pivot index is found, return -1.
        return -1;
    }
}
