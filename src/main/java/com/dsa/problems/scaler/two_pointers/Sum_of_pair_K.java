
/**
 * Given A[n] of sorted elements. Check if there exists a pair (i, j) such that
 * A[i] + A[j] = k and i != j.
 */
package com.dsa.problems.scaler.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum_of_pair_K {
  public static boolean checkForSum(ArrayList<Integer> A, int B) {
    int n = A.size();
    int i = 0;
    int j = n - 1;
    while (i < j) {
      int sum = A.get(i) + A.get(j);
      if (sum == B) {
        return true;
      } else if (sum < B) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int B = 5;
    System.out.println(checkForSum(A, B));
  }
}