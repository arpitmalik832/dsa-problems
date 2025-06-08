package com.dsa.problems.scaler.hashing;

import java.util.*;

public class count_subarray_with_sum_0 {
  /**
   * Q. Count Subarray Zero Sum
   *
   * Given an array A of N integers.
   * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
   *
   * Problem Constraints
   * 1 <= N <= 105
   * -109 <= A[i] <= 109
   *
   * Input Format
   * Single argument which is an integer array A.
   *
   * Output Format
   * Return an integer.
   */
  private static int MOD = (int)Math.pow(10, 9) + 7;

  private static int countSubarray(ArrayList<Integer> A) {
    ArrayList<Integer> pf = new ArrayList<>();
    pf.add(A.get(0));
    for(int i = 1; i < A.size(); i++) {
      pf.add(pf.get(i - 1) + A.get(i));
    }

    HashMap<Integer, Integer> hm = new HashMap<>();
    int rslt = 0;
    for(int i = 0; i < A.size(); i++) {
      if(pf.get(i) == 0) {
        rslt = ((rslt % MOD) + 1) % MOD;
      }
      if(hm.containsKey(pf.get(i))) {
        rslt = ((rslt % MOD) + (hm.get(pf.get(i)) % MOD)) % MOD;
      }
      if(hm.containsKey(pf.get(i))) {
        hm.put(pf.get(i), hm.get(pf.get(i)) + 1);
      } else {
        hm.put(pf.get(i), 1);
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(countSubarray(new ArrayList<>(Arrays.asList(1, -1, -2, 2))));
  }
}
