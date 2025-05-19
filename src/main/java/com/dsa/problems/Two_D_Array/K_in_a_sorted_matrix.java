/**
 * Find out if k is there in the sorted matrix
 */

package com.dsa.problems.Two_D_Array;

import java.util.*;

public class K_in_a_sorted_matrix {

  /**
   * Optimized Approach using benefit of the sorted matrix
   */
  public static int findKInSortedMatrixOptimized(ArrayList<ArrayList<Integer>> A, int B) {
    int n = A.size();
    int m = A.get(0).size();

    int i = 0;
    int j = m - 1;
    while (i < n && j >= 0) {
      if (A.get(i).get(j) == B) {
        return 1;
      }
      if (A.get(i).get(j) >= B) {
        j--;
      } else {
        i++;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        findKInSortedMatrixOptimized(
            new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                new ArrayList<Integer>(Arrays.asList(4, 5, 6)),
                new ArrayList<Integer>(Arrays.asList(7, 8, 9)))),
            5));
  }
}
