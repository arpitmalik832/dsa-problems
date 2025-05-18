/**
 * Given an array A[n] and an integer B. Check if there exists a pair (i, j) such that A[i] - A[j] = B and i != j.
 */

package com.dsa.problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_Pair_Diff_II {
  public static int checkPairDiff(ArrayList<Integer> A, int B) {
    A.sort((a, b) -> a - b);
    int n = A.size();
    int i = 0;
    int j = 1;
    int count = 0;

    while (j < n) {
      long diff = Math.abs((long) A.get(j) - A.get(i)); // Cast to long to prevent overflow
      if (diff == B) {
        count++;
        int currentI = A.get(i);
        int currentJ = A.get(j);
        while (j < n && A.get(j) == currentJ) {
          j++;
        }
        while (i < n && A.get(i) == currentI) {
          i++;
        }
        if (i >= j) {
          j = i + 1;
        }
      } else if (diff < B) {
        j++;
      } else {
        i++;
        if (i == j) {
          j++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(checkPairDiff(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), 3));
    System.out.println(checkPairDiff(
        new ArrayList<Integer>(Arrays.asList(5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5)),
        3));
  }
}
