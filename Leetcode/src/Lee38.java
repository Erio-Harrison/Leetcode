package src;

public class Lee38 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String result = "1";

        while (n > 1) {
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                int count = 1;

                while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                    count++;
                    i++;
                }

                current.append(count).append(result.charAt(i));
            }

            result = current.toString();
            n--;
        }

        return result;
    }
}
