package com.dsa.problems.scaler.gcd;

import java.util.ArrayList;

public class largest_coprime_divisor {

  public static int gcd(int n, int m) {
    if (m == 0) {
      return n;
    }
    return gcd(m, n % m);
  }

  public static ArrayList<Integer> findFactors(int n) {
    ArrayList<Integer> rslt = new ArrayList<>();
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        if (n / i == i) {
          rslt.add(i);
        } else {
          rslt.add(i);
          rslt.add(n / i);
        }
      }
    }

    return rslt;
  }

/**
 * Largest Coprime Divisor
 *
 * You are given two positive numbers A and B. You need to find the maximum valued integer X such that:
 *
 * X divides A i.e. A % X = 0
 * X and B are co-prime i.e. gcd(X, B) = 1
 *
 * For example,
 */
  public static int soln(int A, int B) {
    ArrayList<Integer> factors = findFactors(A);

    int ans = 0;
    for (int i = 0; i < factors.size(); i++) {
      if (factors.get(i) >= B && gcd(factors.get(i), B) == 1) {
        ans = Math.max(ans, factors.get(i));
      } else if (gcd(B, factors.get(i)) == 1) {
        ans = Math.max(ans, factors.get(i));
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(soln(30, 12));
  }
}
