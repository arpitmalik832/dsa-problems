package com.dsa.problems.scaler.bitwise_Operators;

public class multiplication {
  public static int soln(int A, int B) {
    int rslt = 0;
    while(B > 0) {
      if((B & 1) != 0) {
        rslt += A;
      }
      A <<= 1;
      B >>= 1; 
    }

    return rslt;
  }
  public static void main(String[] args) {
    System.out.println(soln(12, 5));
  }
}
