package src;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

public class Lee239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements less than the current one
            // This ensures the deque's first index always points to the max element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // The first element in the deque is the max of the current window,
            // add it to the result array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // If the left end of the window has moved past an element, remove it
            if (i >= k) {
                treeMap.put(nums[i - k], treeMap.get(nums[i - k]) - 1);
                if (treeMap.get(nums[i - k]) == 0) {
                    treeMap.remove(nums[i - k]);
                }
            }

            // Add the current number to the TreeMap
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);

            // If we've filled the first window, record the max
            if (i >= k - 1) {
                result[i - k + 1] = treeMap.lastKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] x = maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(int i:x){
            System.out.println(i);
        }
    }
}
