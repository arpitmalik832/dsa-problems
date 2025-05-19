/**
 * Kadane's Algorithm
 *
 * Given an integer array arr[]. You need to find the maximum sum of a subarray.
 *
 * Examples:
 *
 * Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
 * Output: 11
 * Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.
 *
 * Input: arr[] = [-2, -4]
 * Output: -2
 * Explanation: The subarray {-2} has the largest sum -2.
 *
 * Input: arr[] = [5, 4, 1, 7, 8]
 * Output: 25
 * Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.
 *
 * Constraints:
 * 1 ≤ arr.size() ≤ 10^5
 * -10^9 ≤ arr[i] ≤ 10^4
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Explanation of Kadane's Algorithm:
 * 1. Initialize two variables:
 *    - maxSoFar: tracks the maximum sum found so far
 *    - maxEndingHere: tracks the maximum sum of subarray ending at current position
 *
 * 2. For each element in the array:
 *    - Update maxEndingHere by adding current element
 *    - If maxEndingHere becomes negative, reset it to 0
 *    - Update maxSoFar if maxEndingHere is greater
 *
 * 3. Return maxSoFar
 *
 * Intuition:
 * - We keep track of the maximum sum of subarrays ending at each position
 * - If adding the current element makes the sum negative, we start fresh
 * - This ensures we always have the maximum possible sum
 */

package com.dsa.problems.arrays;

import java.util.*;

public class Kadane_Algorithm {
  public static int kadaneAlgorithm(ArrayList<Integer> arr) {
    int maxSoFar = arr.get(0); // Initialize with first element
    int maxEndingHere = arr.get(0); // Initialize with first element

    for (int i = 1; i < arr.size(); i++) {
      // Either start a new subarray or continue the previous one
      maxEndingHere = Math.max(arr.get(i), maxEndingHere + arr.get(i));
      // Update the maximum sum found so far
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
    System.out.println(kadaneAlgorithm(new ArrayList<>(Arrays.asList(2, 3, -8, 7, -1, 2, 3)))); // 11
    System.out.println(kadaneAlgorithm(new ArrayList<>(Arrays.asList(-2, -4)))); // -2
    System.out.println(kadaneAlgorithm(new ArrayList<>(Arrays.asList(5, 4, 1, 7, 8)))); // 25
  }
}
