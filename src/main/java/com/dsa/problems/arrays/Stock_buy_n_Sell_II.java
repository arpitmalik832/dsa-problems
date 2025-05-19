/**
 * Stock Buy and Sell – Max one Transaction Allowed
 * Difficulty: EasyAccuracy: 49.33%Submissions: 82K+Points: 2Average Time: 10m
 *
 * Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
 *
 * Note: Stock must be bought before being sold.
 *
 * Examples:
 *
 * Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
 * Output: 8
 * Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9. Hence, the profit is 8.
 *
 * Input: prices[] = [7, 6, 4, 3, 1]
 * Output: 0
 * Explanation: Here the prices are in decreasing order, hence if we buy any day then we cannot sell it at a greater price. Hence, the answer is 0.
 *
 * Input: prices[] = [1, 3, 6, 9, 11]
 * Output: 10
 * Explanation: Since the array is sorted in increasing order, we can make maximum profit by buying at price[0] and selling at price[n-1].
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
 * 1. Initialize minPrice to first price and maxProfit to 0
 * 2. Iterate through the prices array
 * 3. Update minPrice if current price is lower
 * 4. Calculate potential profit and update maxProfit if it's higher
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Stock_buy_n_Sell_II {
  public static int maxProfit(ArrayList<Integer> prices) {
    if (prices.size() < 2)
      return 0;

    int minPrice = prices.get(0);
    int maxProfit = 0;

    for (int i = 1; i < prices.size(); i++) {
      minPrice = Math.min(minPrice, prices.get(i));
      maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
    }

    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new ArrayList<>(Arrays.asList(7, 10, 1, 3, 6, 9, 2)))); // 8
    System.out.println(maxProfit(new ArrayList<>(Arrays.asList(7, 6, 4, 3, 1)))); // 0
    System.out.println(maxProfit(new ArrayList<>(Arrays.asList(1, 3, 6, 9, 11)))); // 10
  }
}
