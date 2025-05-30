package com.dsa.problems.scaler.recursion;

public class print_dec {
  public static void printDec(int n) {
    if(n == 0) {
      return;
    }
    System.out.print(n + " ");
    printDec(n - 1);
  }

  public static void main(String[] args) {
    printDec(5);
  }
}
