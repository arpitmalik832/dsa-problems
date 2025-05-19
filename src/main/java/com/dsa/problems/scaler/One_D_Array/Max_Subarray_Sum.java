/**
 *  Max Sum Contiguous Subarray
 *
 * Given an array A of length N, your task is to find the maximum possible sum of any non-empty contiguous subarray.
 *
 * In other words, among all possible subarrays of A, determine the one that yields the highest sum and return that sum.
 *
 * Problem Constraints
 *
 * 1 <= N <= 106
 * -1000 <= A[i] <= 1000
 *
 * Input Format
 *
 * The first and the only argument contains an integer array, A.
 *
 * Output Format
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1, 2, 3, 4, -10]
 *
 * Input 2:
 *
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Example Output
 *
 * Output 1:
 *
 * 10
 *
 * Output 2:
 *
 * 6
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Explanation 2:
 *
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 *
 */

package com.dsa.problems.scaler.One_D_Array;

import java.util.*;

public class Max_Subarray_Sum {

  /**
   * Optimized solution using prefix sum
   * Time complexity: O(N^2)
   * Space complexity: O(N)
   */
  public static int soln(ArrayList<Integer> A) {
    int n = A.size();

    int maxSoFar = 0;
    int maxEndingHere = 0;
    for (int i = 0; i < n; i++) {
      if (maxEndingHere >= 0) {
        maxEndingHere += A.get(i);
      } else {
        maxEndingHere = A.get(i);
      }
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
      }
    }

    return maxSoFar;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10))));
  }
}
