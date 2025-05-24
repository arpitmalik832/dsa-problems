package com.dsa.problems.scaler.bitwise_Operators;

public class magic_number {

  /**
   * Q. Find nth Magic Number
   *
   * Given an integer A, find and return the Ath magic number.
   * A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
   * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
   */
  public static boolean checkBit(int A, int B) {
    return ((A >> B) & 1) == 1;
  }

  public static int soln(int A) {
    int rslt = 0;
    for (byte i = 0; i < 32; i++) {
      if (checkBit(A, i)) {
        rslt += Math.pow(5, i + 1);
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(soln(1));
    System.out.println(soln(3));
    System.out.println(soln(4));
  }
}
