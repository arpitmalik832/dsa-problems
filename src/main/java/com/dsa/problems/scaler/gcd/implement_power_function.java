package com.dsa.problems.scaler.gcd;

public class implement_power_function {

/**
 * Q. Implement Power Function
 *
 * Implement pow(A, B) % C.
 * In other words, given A, B and C, Find (A^B % C).
 * Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 */
  public static int solnRec(int A, int B, int C) {
    if (B == 0) {
      return 1;
    }

    final long temp = (long)(solnRec(A, B / 2, C));

    if ((B & 1) == 0) {
      return (int)((temp * temp) % C);
    } else {
      return ((int)((temp * temp) % C) * (A % C)) % C;
    }
  }

  public static int soln(int A, int B, int C) {
    if (A < 0) {
      A = ((A % C) + C) % C;
    }

    return solnRec(A, B, C);
  }

  public static void main(String[] args) {
    System.out.println(soln(2, 3, 3));
  }
}
