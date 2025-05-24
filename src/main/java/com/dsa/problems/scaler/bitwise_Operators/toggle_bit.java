package com.dsa.problems.scaler.bitwise_Operators;

public class toggle_bit {
  public static int toggleBit(int A, int B) {
    return A ^ (1 << B);
  }

  public static void main(String[] args) {
    System.out.println(toggleBit(5, 1));
  }
}
