package src;

public class Lee5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = helpFunction(s, i, i);  // Odd length palindrome
            int len2 = helpFunction(s, i, i + 1);  // Even length palindrome

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int helpFunction(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome1(String str) {

        int n=str.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    dp[i][j]=1;
            }
        }
        int[] ans = new int[]{0, 0};
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                dp[i][i+1]=1;
                ans[0]=i;
                ans[1]=i+1;
            }
        }
        for(int j=2;j<n;j++){
            for(int i=0;i<n-j;i++){
                int k=i+j;
                if(str.charAt(i)==str.charAt(k)&&dp[i+1][k-1]>0){
                    dp[i][k]=1;
                    ans[0]=i;
                    ans[1]=k;
                }
            }
        }
        return str.substring(ans[0],ans[1]+1);

    }
}
