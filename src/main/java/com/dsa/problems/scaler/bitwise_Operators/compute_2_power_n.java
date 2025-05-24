package com.dsa.problems.scaler.bitwise_Operators;

public class compute_2_power_n {
  /**
   * Q. Computer 2^n for any given n.
   */
  public static int compute(int A) {
    return 1 << A;
  }

  public static void main(String[] args) {
    System.out.println(compute(1));
    System.out.println(compute(4));
  }
}
