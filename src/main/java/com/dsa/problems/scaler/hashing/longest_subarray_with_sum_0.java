package com.dsa.problems.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class longest_subarray_with_sum_0 {
  /**
   * Q. Longest Subarray Zero Sum
   *
   * Given an array A of N integers.
   * Find the length of the longest subarray in the array which sums to zero.
   * If there is no subarray which sums to zero then return 0.
   *
   * Problem Constraints
   * 1 <= N <= 105
   * -109 <= A[i] <= 109
   *
   * Input Format
   * Single argument which is an integer array A.
   *
   * Output Format
   * Return an integer
   */ 
  private static int longestSubarrayWithSum0(ArrayList<Integer> A) {
    for(int i = 1; i < A.size(); i++) {
      A.set(i, A.get(i - 1) + A.get(i));
    }

    int ans = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i = 0; i < A.size(); i++) {
      if(A.get(i) == 0) {
        ans = Math.max(ans, i + 1);
      }
      if(hm.containsKey(A.get(i))) {
        ans = Math.max(i - hm.get(A.get(i)), ans);
      } else {
        hm.put(A.get(i), i);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestSubarrayWithSum0(new ArrayList<>(Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1))));
    System.out.println(longestSubarrayWithSum0(new ArrayList<>(Arrays.asList(-16, 16, 3))));
  }
}