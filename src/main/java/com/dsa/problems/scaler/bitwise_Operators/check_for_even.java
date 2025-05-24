package com.dsa.problems.scaler.bitwise_Operators;

public class check_for_even {
  /**
   * Q. Given an integer. Return true if it is an even integer.
   */ 
  public static boolean checkForEven(int A) {
    return (A & 1) == 0;
  }

  public static void main(String[] args) {
    System.out.println(checkForEven(2));
    System.out.println(checkForEven(3));
  }
}
