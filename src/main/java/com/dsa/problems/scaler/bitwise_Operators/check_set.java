package com.dsa.problems.scaler.bitwise_Operators;

public class check_set {
  public static boolean checkIsSet(int A, int B) {
    return ((A >> B) & 1) == 1;
  }

  public static void main(String[] args) {
    System.out.println(checkIsSet(3, 1));
    System.out.println(checkIsSet(5, 2));
    System.out.println(checkIsSet(5, 1));
  }
}
