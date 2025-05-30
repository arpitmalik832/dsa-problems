package com.dsa.problems.scaler.bitwise_Operators;

public class addition {
  /**
   * Implement a function to add two numbers using bitwise operators.
   */
  public static int add(int A, int B) {
    while(B != 0) {
      int carry = A & B;
      A = A ^ B;
      B = carry << 1;
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println(add(1, 2));
    System.out.println(add(10, 20));
  }
}
