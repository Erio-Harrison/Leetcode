package src;

public class Lee10 {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return isValid(s.length()-1, p.length()-1,s,p,dp);
    }

    public boolean isValid(int sIdx, int pIdx, String s, String p, int[][] dp) {
        if(pIdx==-1) return sIdx == -1;
        if(sIdx==-1) {
            while(pIdx >=0) {
                if(p.charAt(pIdx)!='*') return false;
                pIdx-=2;
            }
            return true;
        }
        if(dp[sIdx][pIdx]!=0) return dp[sIdx][pIdx]==1;
        char sCh = s.charAt(sIdx);
        char pCh = p.charAt(pIdx);
        boolean validity = false;
        if(sCh==pCh || pCh=='.') validity = isValid(sIdx-1,pIdx-1,s,p,dp);
        else if(pCh=='*') {
            validity = isValid(sIdx,pIdx-2,s,p,dp);
            if(!validity && (p.charAt(pIdx-1) == sCh || p.charAt(pIdx-1)=='.')) {
                validity = isValid(sIdx-1,pIdx,s,p,dp);
            }
        }
        dp[sIdx][pIdx] = validity ? 1 : -1;
        return validity;
    }
}
