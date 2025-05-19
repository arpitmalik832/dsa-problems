/**
 * Find the sum of all submatrices of a given matrix
 */

package com.dsa.problems.Two_D_Array;

import java.util.*;

public class Sum_of_all_submatrices_sum {
  public static int soln(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    int m = A.get(0).size();

    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sum += A.get(i).get(j) * (i + 1) * (j + 1) * (n - i) * (m - j);
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(soln(new ArrayList<ArrayList<Integer>>(Arrays.asList(
        new ArrayList<Integer>(Arrays.asList(1, 1)),
        new ArrayList<Integer>(Arrays.asList(1, 1))))));
  }
}
