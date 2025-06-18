package com.dsa.problems.scaler.binary_search;

public class square_root {
  private static int squareRoot(int A) {
    int i = 1, j = A;
    int rslt = 0;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(m * m <= A) {
        rslt = m;
        i = m + 1;
      } else {
        j = m - 1;
      }
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(squareRoot(4));
    System.out.println(squareRoot(5));
  }
}
