package src;

public class Lee121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minSofar = prices[0];
        for(int i=1;i<prices.length;i++){
            if(minSofar>prices[i]){
                minSofar=prices[i];
            }else if(prices[i]-minSofar>max){
                max = prices[i] - minSofar;
            }
        }
        return max;
    }
}
