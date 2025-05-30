package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class subarray_or_sum {
  public static int subarrayOR(ArrayList<Integer> A) {
    int n = A.size();
    int MOD = (int) Math.pow(10,9) + 7;
    int totalSubarrays = (n * (n + 1) / 2) % MOD;
    int rslt = 0;
    for(int i = 0; i < 32; i++) {
      int zeroSubarrays = 0;
      int tempCount = 0;
      for (int j = 0; j < n; j++) {
        if ((A.get(j) & (1 << i)) == 0) {
          tempCount++;
        } else {
          zeroSubarrays = (zeroSubarrays + (tempCount * (tempCount + 1)) / 2) % MOD;
          tempCount = 0;
        }
      }
      zeroSubarrays = (zeroSubarrays + (tempCount * (tempCount + 1)) / 2) % MOD;
      int curr = ((totalSubarrays - zeroSubarrays + MOD)) % MOD;
      curr = (curr * (1 << i)) % MOD;
      rslt = (rslt + curr) % MOD;
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(subarrayOR(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)))); // 71
    System.out.println(subarrayOR(new ArrayList<>(Arrays.asList(7, 8, 9, 10)))); // 110
  }
}
