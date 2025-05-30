package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class min_xor_value {
  public static int findMinXor(ArrayList<Integer> A) {
    Collections.sort(A);
    int minXor = A.get(0) ^ A.get(1);
    for(int i = 2; i < A.size(); i++) {
      minXor = Math.min(minXor, A.get(i) ^ A.get(i - 1));
    }

    return minXor;
  }

  public static void main(String[] args) {
    System.out.println(findMinXor(new ArrayList<>(Arrays.asList(0, 2, 5, 7))));
  }
}
