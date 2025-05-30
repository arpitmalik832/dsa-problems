package com.dsa.problems.scaler.recursion;

public class factorial {
  public static int getFactorial(int n) {
    if(n == 0) {
      return 1;
    }

    return getFactorial(n - 1) * n;
  }

  public static void main(String[] args) {
    System.out.println(getFactorial(5));
  }
}
