package com.dsa.problems.scaler.hashing;

import java.util.*;

public class count_pair_difference {
  /**
   * Q. Count Pair Difference
   *
   * You are given an array A of N integers and an integer B.
   * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
   *
   * Since the answer can be very large, return the remainder after dividing the count with 109+7.
   */
  private static int MOD = (int)Math.pow(10, 9) + 7;

  private static int countPairDifference(ArrayList<Integer> A, int B) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int ans = 0;
    for(int a: A) {
      int comp1 = B + a;
      int comp2 = a - B;
      if(hm.containsKey(comp1)) {
        ans = ((ans % MOD) + (hm.get(comp1) % MOD)) % MOD;
      }
      if(hm.containsKey(comp2)) {
        ans = ((ans % MOD) + (hm.get(comp2) % MOD)) % MOD;
      }
      if(!hm.containsKey(a)) {
        hm.put(a, 1);
      } else {
        hm.put(a, hm.get(a) + 1);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(countPairDifference(new ArrayList<>(Arrays.asList(3, 5, 1, 2)), 4));
  }
}
