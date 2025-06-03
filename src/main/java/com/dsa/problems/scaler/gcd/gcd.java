package com.dsa.problems.scaler.gcd;

public class gcd {
/**
 * Q2. Greatest Common Divisor
 *
 * Given 2 non-negative integers A and B, find gcd(A, B)
 *
 * GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
 *
 * Note: DO NOT USE LIBRARY FUNCTIONS.
 */
  public static int soln(int A, int B) {
    if (B == 0) {
      return A;
    }
    return soln(B, A % B);
  }

  public static void main(String[] args) {
    System.out.println(soln(4, 6));
    System.out.println(soln(6, 4));
  }
}
