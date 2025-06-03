package com.dsa.problems.scaler.bitwise_Operators;

import java.util.ArrayList;
import java.util.Arrays;

public class equal_partitions {
  /**
 * Partition Array into Two Equal Product Subsets
 *
 * You are given an integer array nums containing distinct positive integers and an integer target.
 *
 * Determine if you can partition nums into two non-empty disjoint subsets, with each element belonging to exactly one subset, such that the product of the elements in each subset is equal to target.
 *
 * Return true if such a partition exists and false otherwise.
 *
 * A subset of an array is a selection of elements of the array.
 */
  public static boolean soln(ArrayList<Integer> nums, int target) {
    final int n = nums.size();
    final int total = 1 << n;

    int totalProd = 1;
    for (int i : nums) {
      if (i > target) return false;
      totalProd *= i;
    }

    if (totalProd != target * target) return false;

    for (int i = 1; i < total / 2; i++) {
      int prod = 1;
      boolean isOverFlowed = false;
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          prod *= nums.get(j);
          if (prod > target) {
            isOverFlowed = true;
            break;
          }
        }
      }
      if (isOverFlowed) continue;
      if (prod == target) return true;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<>(Arrays.asList(3, 1, 6, 8, 4)), 24));
  }
}
