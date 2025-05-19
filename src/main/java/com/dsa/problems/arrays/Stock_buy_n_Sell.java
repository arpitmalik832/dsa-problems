/**
 * Stock Buy and Sell – Multiple Transaction Allowed
 *
 * The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock i at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
 *
 * Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.
 *
 * Examples:
 *
 * Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.
 *
 * Input: prices[] = [4, 2, 2, 2, 4]
 * Output: 2
 * Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2. Maximum Profit = 2.
 *
 * Constraints:
 * 1 <= prices.size() <= 10^5
 * 0 <= prices[i] <= 10^4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Steps:
 * 1. Iterate through the prices array
 * 2. If the current price is greater than the previous price, add the difference to the maxProfit
 * 3.Return the maxProfit
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Stock_buy_n_Sell {
  public static int maxProfit(ArrayList<Integer> prices) {
    int maxProfit = 0;

    for (int i = 1; i < prices.size(); i++) {
      if (prices.get(i) > prices.get(i - 1)) {
        maxProfit += prices.get(i) - prices.get(i - 1);
      }
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new ArrayList<>(Arrays.asList(100, 180, 260, 310, 40, 535, 695)))); // 865
    System.out.println(maxProfit(new ArrayList<>(Arrays.asList(4, 2, 2, 2, 4)))); // 2
  }
}
