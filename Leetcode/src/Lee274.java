package src;

import java.util.Arrays;

public class Lee274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                h = n - i;
            } else {
                break;
            }
        }

        return h;
    }
}
