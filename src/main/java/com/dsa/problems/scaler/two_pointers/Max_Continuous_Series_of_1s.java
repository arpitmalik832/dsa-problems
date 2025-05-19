/**
 * Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
 * For this problem, return the indices of maximum continuous series of 1s in order.
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
package com.dsa.problems.scaler.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Max_Continuous_Series_of_1s {
  public static ArrayList<Integer> maxContinuousSeriesOf1s(ArrayList<Integer> A, int B) {
    int n = A.size();

    int i = 0;
    int j = 0;
    int zeroCount = 0;
    int start = -1;
    int maxLength = 0;

    while (j < n) {
      if (A.get(j) == 0) {
        zeroCount++;
      }

      if (zeroCount > B) {
        while (zeroCount > B) {
          if (A.get(i) == 0) {
            zeroCount--;
          }
          i++;
        }
      }

      if (maxLength < j - i + 1) {
        maxLength = j - i + 1;
        start = i;
      }

      j++;
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int x = start; x < start + maxLength; x++) {
      result.add(x);
    }

    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1));
    int B = 2;
    System.out.println(maxContinuousSeriesOf1s(A, B));
  }
}
