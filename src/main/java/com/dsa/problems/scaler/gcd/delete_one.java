package com.dsa.problems.scaler.gcd;

import java.util.ArrayList;
import java.util.Arrays;

public class delete_one {
/**
 * Q. Delete one
 *
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 *
 * Find the maximum value of GCD.
 *
 * Problem Constraints
 *
 * 2 <= N <= 10^5
 * 1 <= A[i] <= 10^9
 */
  public static int getGcd(int A, int B) {
    if (B == 0) {
      return A;
    }

    return getGcd(B, A % B);
  }

public static int soln(ArrayList<Integer> A) {
  final int n = A.size();
  ArrayList<Integer> pGcd = new ArrayList<>();
  ArrayList<Integer> sGcd = new ArrayList<>();
  for(int i : A) {
    pGcd.add(i);
    sGcd.add(i);
  }

  for (int i = 1; i < n; i++) {
    pGcd.set(i, getGcd(pGcd.get(i - 1), pGcd.get(i)));
  }

  for (int i = n - 2; i >= 0; i--) {
    sGcd.set(i, getGcd(sGcd.get(i + 1), sGcd.get(i)));
  }

  int rslt = Math.max(sGcd.get(1), pGcd.get(n - 2));

  for (int i = 1; i < n - 1; i++) {
    rslt = Math.max(rslt, getGcd(pGcd.get(i - 1), sGcd.get(i + 1)));
  }

  return rslt;
}

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(12, 15, 18))));
  }
}
