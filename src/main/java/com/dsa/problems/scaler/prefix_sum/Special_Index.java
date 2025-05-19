/**
 * Given an array, find the count of array indices such that removing an element from these indices
 * makes the sum of even-indexed and odd-indexed array elements equal.
 *
 */
package com.dsa.problems.scaler.prefix_sum;

import java.util.ArrayList;
import java.util.Scanner;

public class Special_Index {
  static public ArrayList<Integer> getPrefixSum(ArrayList<Integer> A, String type) {
    ArrayList<Integer> prefixSum = new ArrayList<>();

    int n = A.size();
    for (int i = 0; i < n; i++) {
      if (type.equals("even")) {
        if (i % 2 == 0) {
          if (i == 0) {
            prefixSum.add(A.get(i));
          } else {
            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
          }
        } else {
          prefixSum.add(prefixSum.get(i - 1));
        }
      } else if (type.equals("odd")) {
        if (i % 2 == 1) {
          prefixSum.add(prefixSum.get(i - 1) + A.get(i));
        } else {
          if (i == 0) {
            prefixSum.add(0);
          } else {
            prefixSum.add(prefixSum.get(i - 1));
          }
        }
      }
    }

    return prefixSum;
  }

  public static int countSpecialIndices(ArrayList<Integer> A) {
    int n = A.size();
    ArrayList<Integer> evenPrefixSum = getPrefixSum(A, "even");
    ArrayList<Integer> oddPrefixSum = getPrefixSum(A, "odd");

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        if (evenPrefixSum.get(n - 1) - A.get(0) == oddPrefixSum.get(n - 1)) {
          count++;
        }
      } else {
        int newEvenSum = evenPrefixSum.get(i - 1) + oddPrefixSum.get(n - 1) - oddPrefixSum.get(i);
        int newOddSum = oddPrefixSum.get(i - 1) + evenPrefixSum.get(n - 1) - evenPrefixSum.get(i);
        if (newOddSum == newEvenSum) {
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      ArrayList<Integer> A = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        A.add(sc.nextInt());
      }
      System.out.println(countSpecialIndices(A));
    }
  }
}
