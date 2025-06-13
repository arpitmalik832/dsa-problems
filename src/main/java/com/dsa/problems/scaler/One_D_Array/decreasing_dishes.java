package com.dsa.problems.scaler.One_D_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class decreasing_dishes {
  /**
   * Decreasing dishes
   *
   * Given an array of N positive integers representing the weights of ingredients in a dish.
   * Find the maximum possible sum of a subarray with decreasing weights.
   *
   * Problem Constraints
   * 1 <= N <= 105
   * 0 <= A[i] <= 105
   *
   * Sum of all elements of A <= 109
   */
  private static int decreasingDishes(ArrayList<Integer> A) {
    int sum = A.get(0);
    int tempSum = A.get(0);
    for(int i = 1; i < A.size(); i++) {
      if(A.get(i) < A.get(i - 1)) {
        tempSum += A.get(i);
      } else {
        tempSum = A.get(i);
      }
      sum = Math.max(tempSum, sum);
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(decreasingDishes(new ArrayList<>(Arrays.asList(3,2,1,4))));
  }
}
