package com.dsa.problems.scaler.bitwise_Operators;

public class unset_bit {
  public static int unsetBit(int A, int B) {
    return A & ~(1 << B);
  }

  public static void main(String[] args) {
    System.out.println(unsetBit(5, 2));
  }
}
