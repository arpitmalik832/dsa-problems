package com.dsa.problems.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class subarray_with_sum_k {
  /**
   * Q. Subarray Sum Equals K
   *
   * Given an array of integers A and an integer B.
   * Find the total number of subarrays having sum equals to B.
   *
   * Problem Constraints
   * 1 <= length of the array <= 50000
   * -1000 <= A[i] <= 1000
   *
   * Input Format
   * The first argument given is the integer array A.
   * The second argument given is integer B.
   *
   * Output Format
   * Return the total number of subarrays having sum equals to B.
   */
private static int findSubarrayWithSumK(ArrayList<Integer> A, int B) {
  int n = A.size();
  for (int i = 1; i < n; i++) {
    A.set(i, A.get(i - 1) + A.get(i));
  }

  int ans = 0;
  HashMap<Integer, Integer> hm = new HashMap<>();
  for (int i = 0; i < n; i++) {
    if (hm.containsKey(A.get(i) - B)) {
      ans += hm.get(A.get(i) - B);
    }
    if (A.get(i) == B) {
      ans++;
    }

    if (!hm.containsKey(A.get(i))) {
      hm.put(A.get(i), 1);
    } else {
      hm.put(A.get(i), hm.get(A.get(i)) + 1);
    }
  }

  return ans;
}

  public static void main(String[] args) {
    System.out.println(findSubarrayWithSumK(new ArrayList<>(Arrays.asList(1, 0, 1)), 1));
  }
}
