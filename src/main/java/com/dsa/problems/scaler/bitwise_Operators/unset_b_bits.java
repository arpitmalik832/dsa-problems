package com.dsa.problems.scaler.bitwise_Operators;

public class unset_b_bits {
  /**
   * Unset x bits from right
   *
   * Given an integer A. Unset B bits from the right of A in binary.
   *
   * For example, if A = 93 and B = 4, the binary representation of A is 1011101.
   * If we unset the rightmost 4 bits, we get the binary number 1010000, which is equal to the decimal value 80.
   */
  public static int soln(int A, int B) {
    int num = (1 << B) - 1;

    return A & ~num;
  }

  public static void main(String[] args) {
    System.out.println(soln(25, 3));
  }
}
