package com.dsa.problems.scaler.recursion;

public class sum_natural_nos {
  public static int sumNaturalNos(int n) {
    if(n == 1) {
      return 1;
    } 

    return sumNaturalNos(n - 1) + n;
  }

  public static void main(String[] args) {
    System.out.println(sumNaturalNos(5));
  }
}
