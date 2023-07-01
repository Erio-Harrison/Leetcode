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
}
