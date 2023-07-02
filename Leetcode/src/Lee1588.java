package src;

public class Lee1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int result=0;
        for(int len=1;len<=length;len+=2){
            for(int start=0;start+len<=length;start++){
                for(int j=start;j<start+len;j++){
                    result+=arr[j];
                }
            }
        }
        return result;
    }

    public int sumOddLengthSubarrays1(int[] arr) {
        int total = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int end = i + 1;
            int start = n - i;
            int totalSubarrays = end * start;
            int oddSubarrays = totalSubarrays / 2;
            if(totalSubarrays % 2 == 1) {
                oddSubarrays++;
            }
            total += oddSubarrays * arr[i];
        }
        return total;
    }
}
