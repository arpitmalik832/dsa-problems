package com.dsa.problems.scaler.gcd;

public class divisor_game {

  public static int gcd(int n, int m) {
    if (m == 0) {
      return n;
    }
    return gcd(m, n % m);
  }

/**
 * Divisor game
 *
 * Scooby has 3 three integers A, B, and C.
 *
 * Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.
 */
public static int soln(int A, int B, int C) {
  final long gcdVal = B > C ? gcd(B, C) : gcd(C, B);
  final int lcm = (int)((long)(B * C) / gcdVal);
  return (int) Math.floor(A / lcm);
}

  public static void main(String[] args) {
    System.out.println(soln(12, 2, 3));
  }
}
