package com.dsa.problems.scaler.recursion;

public class fast_power {
  public static int fastPower(int A, int B) {
    if(B == 0) {
      return 1;
    }

    int t = fastPower(A, B / 2);
    if((B & 1) == 0) {
      return t * t;
    }

    return t * t * A;
  }

  public static void main(String[] args) {
    System.out.println(fastPower(2, 10));
  }
}
