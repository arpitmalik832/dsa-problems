package com.dsa.problems.scaler.recursion;

public class sum_of_digits {
  public static int sumOfDigits(int n) {
    if(n == 0) {
      return 0;
    }

    return sumOfDigits(n / 10) + n % 10;
  }

  public static void main(String[] args) {
    System.out.println(sumOfDigits(123));
  }
}
