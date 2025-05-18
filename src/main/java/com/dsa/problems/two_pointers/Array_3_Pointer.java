/**
 * You are given 3 sorted arrays A, B and C.
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 */
package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_3_Pointer {
  public static int minimizeMaxDiff(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    int i = 0;
    int j = 0;
    int k = 0;

    int minMaxDiff = Math.max(Math.abs(A.get(i) - B.get(j)),
        Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));

    while (i < A.size() && j < B.size() && k < C.size()) {
      int newMaxDiff = Math.max(Math.abs(A.get(i) - B.get(j)),
          Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));
      minMaxDiff = Math.min(minMaxDiff, newMaxDiff);

      if (A.get(i) <= B.get(j) && A.get(i) <= C.get(k)) {
        i++;
      } else if (B.get(j) <= A.get(i) && B.get(j) <= C.get(k)) {
        j++;
      } else {
        k++;
      }
    }

    return minMaxDiff;
  }

  public static void main(String[] args) {
    System.out.println(minimizeMaxDiff(new ArrayList<Integer>(Arrays.asList(1, 4, 10)),
        new ArrayList<Integer>(Arrays.asList(2, 15, 20)), new ArrayList<Integer>(Arrays.asList(10, 12, 20))));
  }
}
