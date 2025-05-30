package com.dsa.problems.scaler.bitwise_Operators;

public class strange_equality {
  public static int solve(int A) {
    int n = 0;
    int temp = A;

    while(temp > 0) {
      n++;
      temp >>= 1;
    }

    int X = 0;

    for(int i = 0; i < n; i++) {
      if((A & (1 << i)) == 0) {
        X |= (1 << i);
      }
    }

    return X ^ (1 << n);
  }

  public static void main(String[] args) {
    System.out.println(solve(5));
  }
}
