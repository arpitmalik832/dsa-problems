package com.dsa.problems.scaler.bitwise_Operators;

public class reverse_bits {
  public static long reverseBits(int A) {
    long rslt = 0; // Use long to avoid sign issues
    for(int i = 0; i < 32; i++) {
      rslt <<= 1;
      if((A & 1) != 0) {
        rslt |= 1;
      }
      A >>= 1;
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(reverseBits(3));
  }
}
