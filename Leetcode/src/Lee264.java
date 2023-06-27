package src;


import java.util.HashSet;
import java.util.PriorityQueue;


public class Lee264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        long ugly=0;
        set.add(1L);
        queue.add(1L);
        for(int i=0; i<n;i++){
            ugly=queue.remove();
            if(!set.contains(ugly*2)){
                set.add(ugly*2);
                queue.add(ugly*2);
            }
            if(!set.contains(ugly*3)){
                set.add(ugly*3);
                queue.add(ugly*3);
            }
            if(!set.contains(ugly*5)){
                set.add(ugly*5);
                queue.add(ugly*5);
            }
        }
        return (int)ugly;
    }
    public int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1; i<n; i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
