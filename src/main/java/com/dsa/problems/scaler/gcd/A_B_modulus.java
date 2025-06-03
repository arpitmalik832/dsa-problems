package com.dsa.problems.scaler.gcd;

public class A_B_modulus {

/**
 * Q4. A, B and Modulo
 *
 * Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
 */

public static int soln(int A, int B) {
  if (A == B) {
    return A;
  }

  return Math.abs(A - B);
}

  public static void main(String[] args) {
    System.out.println(soln(10, 4));
    System.out.println(soln(15, 3));
  }
}
