/**
 * Q. Closest pair from sorted arrays
 * 
 * Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
 * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
 * If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
 * Return an array with two elements {A[i], B[j]}.
 */
package com.dsa.problems.scaler.two_pointers;

import java.util.ArrayList;

public class Closest_Pair_From_Sorted_arrays {
  public static ArrayList<Integer> closestPair(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    int i = 0;
    int j = B.size() - 1;
    int minDiff = Integer.MAX_VALUE;
    ArrayList<Integer> result = new ArrayList<>();
    while (i < A.size() && j >= 0) {
      int newDiff = Math.abs((A.get(i) + B.get(j)) - C);
      if (newDiff < minDiff) {
        minDiff = newDiff;
        result.clear();
        result.add(A.get(i));
        result.add(B.get(j));
      } else if (newDiff == minDiff) {
        if (A.get(i) < result.get(0) || (A.get(i) == result.get(0) && B.get(j) < result.get(1))) {
          result.clear();
          result.add(A.get(i));
          result.add(B.get(j));
        }
      }
      if (A.get(i) + B.get(j) < C) {
        i++;
      } else {
        j--;
      }
    }
    return result;
  }
}
