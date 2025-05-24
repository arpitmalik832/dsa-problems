package com.dsa.problems.scaler.bitwise_Operators;

public class set_bit {
  public static int setBit(int A, int B) {
    return A | (1 << B);
  }

  public static void main(String[] args) {
    System.out.println(setBit(5, 1));
  }
}
