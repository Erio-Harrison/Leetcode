package src;

public class Lee123 {
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }

    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int firstBuy = Integer.MAX_VALUE, secondBuy = Integer.MAX_VALUE;
        int firstProfit = 0, secondProfit = 0;

        for(int price : prices) {
            if(price < firstBuy) {
                firstBuy = price;
            }else if(price - firstBuy > firstProfit) {
                firstProfit = price - firstBuy;
            }

            if(price - firstProfit < secondBuy) {
                secondBuy = price - firstProfit;
            }else if(price - secondBuy > secondProfit) {
                secondProfit = price - secondBuy;
            }
        }
        return secondProfit;
    }
}
