package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class count_triplets {
  /**
   * Count Triplets That Can Form Two Arrays of Equal XOR
   *
   * Given an array of integers arr.
   * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
   *
   * Let's define a and b as follows:
   * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
   * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
   * Note that ^ denotes the bitwise-xor operation.
   * Return the number of triplets (i, j and k) Where a == b.
   */
  public static int countTriplets(ArrayList<Integer> A) {
    int n = A.size();
    for(int i = 1; i < n; i++) {
      A.set(i, A.get(i) ^ A.get(i - 1)); 
    }

    int rslt = 0;
    for(int i = 0; i < n - 1; i++) {
      for(int k = i + 1; k < n; k++) {
        int xor = 0;
        if(i == 0) {
          xor = A.get(k);
        } else {
          xor = A.get(k) ^ A.get(i - 1);
        }
        if(xor == 0) {
          rslt += k - i;
        }
      }
    }
    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(countTriplets(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
  }
}
