package com.dsa.problems.scaler.recursion;

public class fibonacci {
  public static int getFibonacci(int n) {
    if(n == 0 || n == 1) {
      return n;
    }

    return getFibonacci(n - 1) + getFibonacci(n - 2);
  }

  public static void main(String[] args) {
    System.out.println(getFibonacci(5));
  }
}
