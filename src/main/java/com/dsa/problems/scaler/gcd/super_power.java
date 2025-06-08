package com.dsa.problems.scaler.gcd;

import java.util.ArrayList;
import java.util.Arrays;

public class super_power {
  private static int MOD = 1337;

  public static int powRec(int x, int y) {
    if(y == 0) {
      return 1;
    }

    long temp = powRec(x, y / 2);
    if((y & 1) == 0) {
      return (int)(((temp % MOD) * (temp % MOD)) % MOD);
    } else {
      return (int)(((((temp % MOD) * (temp % MOD)) % MOD) * (x % MOD)) % MOD);
    }
  }

  /**
   * Find A to the power B mod 1337 where B is given in array as its a very large number.
   */
  public static int superPow(int A, ArrayList<Integer> B) {
    int rslt = 1;
    int i = 0;
    while(i < B.size()) {
      rslt = (powRec(rslt, 10) % MOD);
      rslt = ((rslt % MOD) * (powRec(A, B.get(i)) % MOD)) % MOD; 
      i++;
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(superPow(2, new ArrayList<>(Arrays.asList(1, 1))));
  }
}
