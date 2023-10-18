package src;

public class Lee34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result= new int[2];
        result[0]=-1;
        result[1]=-1;
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else{
                end= mid-1;
            }
        }

        if(start>=nums.length||nums[start]!=target){
            return result;
        }

        result[0] = start;
        end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        result[1] = end;
        return result;
    }

    public int[] searchRange1(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                first = i;
                while(i < nums.length && nums[i] == target) {
                    i++;
                }
                last = i - 1;
                return new int[]{first, last};
            }
        }
        return new int[]{first, last};
    }
}
