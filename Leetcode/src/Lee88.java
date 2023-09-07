package src;

import java.util.Arrays;

public class Lee88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1= m-1;
        int p2= n-1;
        int p= m+n-1;

        while(p1>=0 && p2>=0){
            if(nums1[p1]<nums2[p2]){
                nums1[p]=nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }
        while(p2>=0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
