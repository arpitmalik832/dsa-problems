package com.dsa.problems.scaler.gcd;

import java.util.ArrayList;
import java.util.Arrays;

public class mod_sum {

/**
 * Q. Mod Sum
 *
 * Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
 * 1 <= A[i] <= 1000
 *
 */
public static int soln(ArrayList<Integer> A) {
  final int MOD = (int)Math.pow(10, 9) + 7;
  ArrayList<Integer> freq = new ArrayList<>(1000);

  for(int i = 0; i < 1000; i++) {
    freq.set(i, 0);
  }

  for (int i : A) {
    freq.set(i - 1, freq.get(i - 1) + 1);
  }

  int ans = 0;
  for (int i = 0; i < 1000; i++) {
    for (int j = 0; j < A.size(); j++) {
      ans =
        ((ans % MOD) + (((((i + 1) % A.get(j)) % MOD) * (freq.get(i) % MOD)) % MOD)) %
        MOD;
    }
  }

  return ans;
}

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 3))));
    System.out.println(soln(new ArrayList<>(Arrays.asList(17, 100, 11))));
  }
}
