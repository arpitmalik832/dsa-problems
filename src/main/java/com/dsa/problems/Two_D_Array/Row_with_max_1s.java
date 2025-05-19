/**
 * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1s.
 */
package com.dsa.problems.Two_D_Array;

import java.util.*;

public class Row_with_max_1s {
  public static int soln(ArrayList<ArrayList<Integer>> A) {
    int n = A.size();
    int m = A.get(0).size();

    int i = 0;
    int j = m - 1;
    int max1s = -1;
    int rslt = -1;
    while (i < n && j >= 0) {
      if (max1s < m - j) {
        max1s = m - j;
        rslt = i;
      }
      if (j > 0 && A.get(i).get(j - 1) == 1) {
        j--;
      } else {
        i++;
      }
    }

    return rslt;
  }

  public static void main(String[] args) {
    System.out.println(
        soln(
            new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 1))))));

    System.out.println(
        soln(
            new ArrayList<ArrayList<Integer>>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)),
                new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1))))));
  }
}
