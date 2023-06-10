package src;

public class Lee485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int count=0;

        for(int i=0;i< nums.length;i++){
            if(nums[i]==1){
                count+=1;
                max=Math.max(count,max);
            }else{
                count=0;
                max=Math.max(count,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
}
