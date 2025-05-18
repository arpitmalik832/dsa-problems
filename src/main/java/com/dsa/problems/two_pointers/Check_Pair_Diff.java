/**
 * Given an array A[n] and an integer B. Check if there exists a pair (i, j) such that A[i] - A[j] = B and i != j.
 */

package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_Pair_Diff {
  public static boolean checkPairDiff(ArrayList<Integer> A, int B) {
    int n = A.size();
    int i = 0;
    int j = 1;
    while (j < n) {
      int diff = Math.abs(A.get(j) - A.get(i));
      if (diff == B) {
        return true;
      } else if (diff < B) {
        j++;
      } else {
        i++;
        if (i == j) {
          j++;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(checkPairDiff(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 3));
  }
}
