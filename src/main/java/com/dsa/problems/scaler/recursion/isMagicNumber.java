package com.dsa.problems.scaler.recursion;

public class isMagicNumber {
  public static int internalSum(int n) {
    if(n == 0) {
      return n;
    }

    return internalSum(n / 10) + (n % 10);
  }

  public static int sum(int m) {
    if(m / 10 == 0) {
      return m;
    } 
    return sum(internalSum(m));
  }

  public static int isMagic(int A) {
    if(sum(A) == 1) {
      return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(isMagic(83557));
    System.out.println(isMagic(8357));
  }
}
