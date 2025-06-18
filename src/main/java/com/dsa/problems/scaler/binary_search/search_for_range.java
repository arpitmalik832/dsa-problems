package com.dsa.problems.scaler.binary_search;

import java.util.ArrayList;
import java.util.Arrays;

public class search_for_range {
  /**
   * Q. Search for a Range
   *
   * Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
   *
   * Return an array of size 2, such that
   * First element = Left most index of B in A
   * Second element = Right most index of B in A.
   * If B is not found in A, return [-1, -1].
   *
   * Note : The time complexity of your algorithm must be O(log n)..
   */
  private static ArrayList<Integer> searchForRange(ArrayList<Integer> A, int B) {
    int min = -1;
    int max = -1;

    final int n = A.size();
    int i = 0, j = n - 1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) == B) {
        min = m;
        j = m - 1;
      } else if(A.get(m) < B) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    i = 0; j = n - 1;
    while(i <= j) {
      final int m = (i + j) / 2;
      if(A.get(m) == B) {
        max = m;
        i = m + 1;
      } else if(A.get(m) < B) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }

    return new ArrayList<>(Arrays.asList(min, max));
  }

  public static void main(String[] args) {
    System.out.println(searchForRange(new ArrayList<>(Arrays.asList(1,2,2,2,2,3)), 2));
    System.out.println(searchForRange(new ArrayList<>(Arrays.asList(1,2,2,2,2,3)), 3));
    System.out.println(searchForRange(new ArrayList<>(Arrays.asList(1,2,2,2,2,3)), 0));
  }
}
