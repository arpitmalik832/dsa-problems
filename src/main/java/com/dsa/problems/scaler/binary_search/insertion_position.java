package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class insertion_position {
  /**
   * Q. Sorted Insert Position
   *
   * You are given a sorted array A of size N and a target value B.
   * Your task is to find the index (0-based indexing) of the target value in the array.
   *
   * If the target value is present, return its index.
   * If the target value is not found, return the index of least element greater than equal to B.
   * If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
   * Your solution should have a time complexity of O(log(N)).
   */
  private static int insertionPosition(ArrayList<Integer> A, int B) {
    final int n = A.size();
    int i = 0, j = n - 1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) == B) {
        return m;
      } else if(A.get(m) < B) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return i;
  }

  public static void main(String[] args) {
    System.out.println(insertionPosition(new ArrayList<>(Arrays.asList(2,3,4,5,7)), 6));
  }
}
