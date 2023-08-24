package src;

import java.util.HashSet;
import java.util.Set;

public class Lee2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] hasReceived = new boolean[n];
        int position = 0; // Starting position
        hasReceived[0] = true;
        for (int i = 1; ; i++) {
            position = (position + i * k) % n;
            if (hasReceived[position]) {
                break;
            }
            hasReceived[position] = true;
        }

        int count = 0;
        for (boolean received : hasReceived) {
            if (!received) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!hasReceived[i]) {
                result[index++] = i + 1;
            }
        }
        return result;
    }

    public int[] circularGameLosers1(int n, int k) {
        Set<Integer> vis = new HashSet<>();
        int i = 0, rem = 0;
        while(true) {
            rem = (rem + k * i++) % n;
            if (!vis.add(rem)) break; //rem has been visited
        }
        int j = 0, res[] = new int[n - vis.size()];
        for (i = 0; i < n; i++) {
            if (!vis.contains(i)) res[j++] = i + 1;
        }
        return res;
    }
}
