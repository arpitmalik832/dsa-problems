package com.dsa.problems.scaler.bitwise_Operators;

public class subtraction {
  /**
   *  Implement a function to subtract two numbers using bitwise operators.
   */
  public static int subtract(int A, int B) {
    while(B != 0) {
      int borrow = ~(A) & B;
      A = A ^ B;
      B = borrow << 1;
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println(subtract(1, 2));
    System.out.println(subtract(10, 20));
  }
}
