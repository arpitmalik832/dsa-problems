package com.dsa.problems.scaler.recursion;

public class print_dec_n_inc {
  public static void printDecNInc(int n) {
    if(n == 0) {
      return;
    }
    System.out.print(n + " ");
    printDecNInc(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String[] args) {
    printDecNInc(5);
  }
}
