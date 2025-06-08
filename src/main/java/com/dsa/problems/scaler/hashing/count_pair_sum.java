package com.dsa.problems.scaler.hashing;

import java.util.*;

public class count_pair_sum {
  /**
   * Q. Check Pair Sum
   *
   * Given an Array of integers A, and a target sum B.
   * Check if there exists a pair (i,j) such that Ai + Aj = B and i!=j.
   */
  private static int MOD =(int)Math.pow(10, 9) + 7;

  private static int countPairSum(ArrayList<Integer> A, int B) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    int ans = 0;
    for(int a : A) {
      int comp = B - a;
      if(hm.containsKey(comp)) {
        ans = ((ans % MOD) + (hm.get(comp) % MOD)) % MOD;
      }
      if(hm.containsKey(a)) {
        hm.put(a, hm.get(a) + 1);
      } else {
        hm.put(a, 1);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(countPairSum(new ArrayList<>(Arrays.asList(1, 2, 1, 2)), 3));
  }
}
