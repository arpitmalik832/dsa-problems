/**
 * Count pairs with sum k
 * Given an array A[n] and an integer B. Count all pairs (i, j) such that A[i] + A[j] = B and i != j.
 */
package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum_of_Pair_k_II {
  public static int countPairs(ArrayList<Integer> A, int B) {
    final int MOD = 1000000007;
    A.sort((a, b) -> a - b); // Sort array first
    int n = A.size();
    int i = 0;
    int j = n - 1;
    int count = 0;

    while (i < j) {
      int sum = A.get(i) + A.get(j);
      if (sum == B) {
        if (A.get(i).equals(A.get(j))) {
          // Calculate pairs with modulo to prevent overflow
          return (count + (j - i + 1) * (j - i) / 2) % MOD;
        }
        // Count duplicates for both i and j
        int counti = 0;
        int countj = 0;
        int startI = A.get(i);
        int startJ = A.get(j);

        while (i <= j && A.get(i).equals(startI)) {
          counti++;
          i++;
        }
        while (j >= i && A.get(j).equals(startJ)) {
          countj++;
          j--;
        }
        // Add all possible pairs
        count = (count + counti * countj) % MOD;
      } else if (sum < B) {
        i++;
      } else {
        j--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // Test cases
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(countPairs(A, 5)); // 2 pairs: (1,4) and (2,3)

    A = new ArrayList<>(Arrays.asList(1, 2, 6, 6, 7, 9, 9));
    System.out.println(countPairs(A, 13));

    A = new ArrayList<>(Arrays.asList(1, 1, 1));
    System.out.println(countPairs(A, 2)); // 3 pairs: (1,1) appears 3 times

    A = new ArrayList<>(Arrays.asList(4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
        4629666, 4629666));
    System.out.println(countPairs(A, 9259332)); // Should be 3160
  }
}
