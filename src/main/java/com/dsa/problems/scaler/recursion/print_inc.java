package com.dsa.problems.scaler.recursion;

public class print_inc {
  public static void printInc(int n) {
    if(n == 0) {
      return;
    }
    printInc(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    printInc(5);
  }
}
