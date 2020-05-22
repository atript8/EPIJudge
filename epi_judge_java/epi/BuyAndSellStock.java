package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    double prevMin = prices.get(0);
    double max = 0;
    for (int i = 1; i < prices.size(); i++) {
      if (prevMin > prices.get(i)) {
        prevMin = prices.get(i);
      } else {
        double profit = prices.get(i) - prevMin;
        if (max < profit) max = profit;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
