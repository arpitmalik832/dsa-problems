/**
 * Maximum Product Subarray
 *
 * Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].
 *
 * Note: It is guaranteed that the output fits in a 32-bit integer.
 *
 * Examples
 *
 * Input: arr[] = [-2, 6, -3, -10, 0, 2]
 * Output: 180
 * Explanation: The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180.
 *
 * Input: arr[] = [-1, -3, -10, 0, 6]
 * Output: 30
 * Explanation: The subarray with maximum product is {-3, -10} with product = (-3) * (-10) = 30.
 *
 * Input: arr[] = [2, 3, 4]
 * Output: 24
 * Explanation: For an array with all positive elements, the result is product of all elements.
 *
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * -10  ≤  arr[i]  ≤  10
 */

/**
 * Steps:
 * 1. Initialize maxSoFar to arr[0]
 * 2. Initialize maxEndingHere to arr[0]
 * 3. Initialize minEndingHere to arr[0]
 * 4. Iterate through the array
 * 5. If the current element is 0, reset the product to 1
 * 6. If the current element is positive, multiply the product by the current element
 * 7. If the current element is negative, multiply the product by the current element and check if it is greater than the maxProduct
 * 8. Return the maxProduct
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Max_Product_Subarray {
  public static int maxProductSubarray(ArrayList<Integer> arr) {
    int maxSoFar = arr.get(0);
    int maxEndingHere = arr.get(0);
    int minEndingHere = arr.get(0);

    int size = arr.size();
    for (int i = 1; i < size; i++) {
      if (arr.get(i) == 0) {
        maxEndingHere = 1;
        minEndingHere = 1;
        maxSoFar = Math.max(maxSoFar, 0);
      } else {
        int tempMax = Math.max(
            arr.get(i),
            Math.max(maxEndingHere * arr.get(i),
                minEndingHere * arr.get(i)));
        minEndingHere = Math.min(
            arr.get(i),
            Math.min(
                maxEndingHere * arr.get(i),
                minEndingHere * arr.get(i)));
        maxEndingHere = tempMax;
        if (maxEndingHere < minEndingHere) {
          int temp = maxEndingHere;
          maxEndingHere = minEndingHere;
          minEndingHere = temp;
        }
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
      }
    }

    return maxSoFar;
  };

  public static void main(String[] args) {
    System.out.println(maxProductSubarray(new ArrayList<>(Arrays.asList(-2, 6, -3, -10, 0, 2)))); // 180
    System.out.println(maxProductSubarray(new ArrayList<>(Arrays.asList(-1, -3, -10, 0, 6)))); // 30
    System.out.println(maxProductSubarray(new ArrayList<>(Arrays.asList(2, 3, 4)))); // 24
    System.out.println(maxProductSubarray(new ArrayList<>(Arrays.asList(-2, 0, -1)))); // 0
  }
}
