/**
 * Q8. Different Bits Sum Pairwise
 *
 * Problem Description
 *
 * We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
 * For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.
 *
 * You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.
 *
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 2^31 - 1
 *
 */

/**
 * Time Complexity Expectations as per constraints:
 * TC             Iterations     Remarks
 * O(N^2)         10^10          TLE
 * O(N*log(N))    10^6           AC
 * O(N)           10^5           AC
 */
package com.dsa.problems.bitwise_Operators;

import java.util.ArrayList;

public class different_bits_sum_pairwise {
  public static int soln(ArrayList<Integer> A) {
    int length = A.size();
    int sum = 0;

    // For each bit position (0 to 31)
    for (int i = 0; i < 32; i++) {
      int countOnes = 0;

      // Count numbers that have 1 at current bit position
      for (int j = 0; j < length; j++) {
        if (((A.get(j) >> i) & 1) == 1) {
          countOnes++;
        }
      }

      // Calculate different bits at this position
      // countOnes * (length - countOnes) gives us pairs with different bits
      // Multiply by 2 because each pair is counted twice (i,j and j,i)
      sum = (sum + countOnes * (length - countOnes) * 2) % 1000000007;
    }

    return sum;
  }
}
