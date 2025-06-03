package com.dsa.problems.scaler.gcd;

import java.util.ArrayList;
import java.util.Arrays;

public class pair_sum_divisible_by_M {

/**
 * Q. Pair Sum divisible by M
 *
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (10^9 + 7).
 *
 * Note: Ensure to handle integer overflow when performing the calculations.
 */
public static int soln(ArrayList<Integer> A, int B) {
  final int MOD = (int)Math.pow(10, 9) + 7;
  ArrayList<Integer> mods = new ArrayList<>(B);

  for (int i : A) {
    mods.set(i % B, mods.get(i % B) + 1);
  }

  int ans = (((mods.get(0) % MOD) * ((mods.get(0) - 1) % MOD)) / 2) % MOD;
  int i = 1;
  int j = B - 1;

  while (i < j) {
    ans = ((ans % MOD) + (((mods.get(i) % MOD) * (mods.get(j) % MOD)) % MOD)) % MOD;
    i++;
    j--;
  }
  if (i == j) {
    ans =
      ((ans % MOD) + ((((mods.get(i) % MOD) * ((mods.get(i) - 1) % MOD)) / 2) % MOD)) %
      MOD;
  }

  return ans;
}

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 2));
  }
}
