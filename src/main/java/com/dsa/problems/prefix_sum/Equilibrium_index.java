/**
 * Equilibrium Index
 *
 * Problem Description
 * Given an array A of N integers.
 *
 * Find the equilibrium index of the given array.
 *
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 */

package com.dsa.problems.prefix_sum;

import java.util.*;

public class Equilibrium_index {
  public static ArrayList<Long> getPrefixSum(ArrayList<Integer> A) {
    int n = A.size();
    ArrayList<Long> prefixSum = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (i == 0) {
        prefixSum.add((long) A.get(i));
      } else {
        prefixSum.add(prefixSum.get(i - 1) + A.get(i));
      }
    }

    return prefixSum;
  }

  public static int findEquilibriumIndex(ArrayList<Integer> A) {
    int n = A.size();
    ArrayList<Long> prefixSum = getPrefixSum(A);

    if (prefixSum.get(n - 1) == 0) {
      return 0;
    }

    for (int i = 1; i < n - 1; i++) {
      if (prefixSum.get(i - 1) == prefixSum.get(n - 1) - prefixSum.get(i)) {
        return i;
      }
    }

    if (prefixSum.get(n - 2) == 0) {
      return n - 1;
    }

    return -1;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ArrayList<Integer> A = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        A.add(sc.nextInt());
      }
      System.out.println(findEquilibriumIndex(A));
    }
  }
}
