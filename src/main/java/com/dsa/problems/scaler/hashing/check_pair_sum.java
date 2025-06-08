package com.dsa.problems.scaler.hashing;

import java.util.*;

public class check_pair_sum {
  /**
   * Q. Check Pair Sum
   *
   * Given an Array of integers A, and a target sum B.
   * Check if there exists a pair (i,j) such that Ai + Aj = B and i!=j.
   */
  private static boolean pairSum(ArrayList<Integer> A, int B) {
    HashSet<Integer> hs = new HashSet<>();
    for(int i = 0; i < A.size(); i++) {
      final int comp = B - A.get(i);
      if(hs.contains(comp)) {
        return true;
      }
      hs.add(A.get(i));
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(pairSum(new ArrayList<>(Arrays.asList(-1, 2, 3, 2, 1)), 3));
  }
}
