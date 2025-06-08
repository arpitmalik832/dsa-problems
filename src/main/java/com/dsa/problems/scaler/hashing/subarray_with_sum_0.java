package com.dsa.problems.scaler.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class subarray_with_sum_0 {
  /**
   * Q2. Sub-array with 0 sum
   *
   * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
   *
   * If the given array contains a sub-array with sum zero return 1, else return 0.
   *
   * Problem Constraints
   * 1 <= |A| <= 100000
   * -10^9 <= A[i] <= 10^9
   *
   * Input Format
   * The only argument given is the integer array A.
   *
   * Output Format
   * Return whether the given array contains a subarray with a sum equal to 0.
   */
  private static int findSubarrayWithSum0(ArrayList<Integer> A) {
    for(int i = 1; i < A.size(); i++) {
      A.set(i, A.get(i - 1) + A.get(i));
    }

    HashSet<Integer> hs = new HashSet<>();
    for(int i = 0; i < A.size(); i++) {
      if(A.get(i) == 0){
        return 1;
      }
      if(hs.contains(A.get(i))) {
        return 1;
      } else {
        hs.add(A.get(i));  
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(findSubarrayWithSum0(new ArrayList<>(Arrays.asList(2,-1,3,-2,4))));
  }
}
