package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class subarrays_with_OR_1 {
  public static int getSubArraysWithOR1(ArrayList<Integer> A) {
    int n = A.size();
    int totalSubArrays = (n * (n + 1)) / 2;

    int zeroCount = 0;
    int tempCount = 0;
    for(int i : A) {
      if(i == 0) {
        tempCount++;
      } else {
        zeroCount += (tempCount * (tempCount + 1)) / 2;
        tempCount = 0;
      }
    }

    zeroCount += (tempCount * (tempCount + 1)) / 2;

    return totalSubArrays - zeroCount;
  }

  public static void main(String[] args) {
    System.out.println(getSubArraysWithOR1(new ArrayList<>(Arrays.asList(1, 0, 1))));
  }
}
